package co.gov.policia.pwa.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.gov.policia.pwa.entity.EmpleadosSipac;
import co.gov.policia.pwa.entity.PwaSesionesActivas;
import co.gov.policia.pwa.entity.SbParametros;
import co.gov.policia.pwa.entity.VwPwaAdminUsuarios;
import co.gov.policia.pwa.entity.VwPwaPerfilUsuarios;
import co.gov.policia.pwa.payload.request.LoginRequest;
import co.gov.policia.pwa.payload.response.JwtResponse;
import co.gov.policia.pwa.payload.response.ResponseSp;
import co.gov.policia.pwa.security.AuthJwtUtil;
import co.gov.policia.pwa.security.UserDetailServiceImpl;
import co.gov.policia.pwa.service.AdminUsuariosService;
import co.gov.policia.pwa.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/sigicmovil/auth")
public class LoginController {

	@Autowired
	AuthenticationManager authManager;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	AuthJwtUtil jwtUtil;

	@Autowired
	UserDetailServiceImpl userDetailService;

	@Autowired
	UserService userService;

	@Autowired
	AdminUsuariosService adminUsuariosService;

	@SuppressWarnings("unused")
	@PostMapping(value = "/signin", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> iniciarSesion(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {

		boolean contraseniaLdap = false;

		String usuarioConectado = loginRequest.getUsuario().trim();
		String usuarioPassword = loginRequest.getContrasenia();
		String navegadorUsuario = loginRequest.getNavegador();
		System.out.println("navegadorUsuario: " + navegadorUsuario);

		// buscar usuario en la base de datos
		VwPwaAdminUsuarios porUsuarioPwa = new VwPwaAdminUsuarios();
		System.out.println("Usuario a buscar: " + usuarioConectado);

		// if (usuarioConectado.equals("PRUEBA.PRUEBA")) {
		// porUsuarioPwa = userService.buscarPwa(usuarioConectado);
		// } else {
		porUsuarioPwa = userService.buscarPwa(usuarioConectado);
		// }

		if (porUsuarioPwa == null) {
			return ResponseEntity
					.ok(new ResponseSp("-1", "El usuario no esta registrado o no autorizado para ingresar al sistema"));
		}

		if (!"SI".equals(porUsuarioPwa.getActivo())) {
			return ResponseEntity.ok(new ResponseSp("-4", "El usuario no se encuentra activo en la aplicación"));
		}

		if (porUsuarioPwa.getAutorizado().equals(3L)) {
			return ResponseEntity
					.ok(new ResponseSp("-5", "Usuario inactivo en el sistema o con novedad administrativa"));
		}

		// buscar usuario en la base de datos
		SbParametros sbParametros = new SbParametros();
		sbParametros = userService.buscarEnSbParametros("SIPAC", "TIEMPO_TIME_OUT");

		String tiempoTimeOut = sbParametros.getValorParametro();
		System.out.println("tiempoTimeOut: " + tiempoTimeOut);

		ArrayList<VwPwaPerfilUsuarios> objetosPorUsuario = userService.obtenerObjetosUsuario(usuarioConectado);

		Map<String, String> roles = new HashMap<String, String>();

		for (VwPwaPerfilUsuarios perfil : objetosPorUsuario) {
			roles.put(perfil.getFuncion(), perfil.getNombreFuncion());
		}

		System.out.println("roles: " + roles);
		
		if (objetosPorUsuario == null) {
			return ResponseEntity.ok(new ResponseSp("-6",
					"No tiene perfiles asignados a PWA. Por favor contacte con el Administrador."));
		}

		PwaSesionesActivas sessionActivaBuscar = new PwaSesionesActivas();

		sessionActivaBuscar = userService.buscarSessionActivaByUsuario(usuarioConectado);

		System.out.println("sessionActivaBuscar: " + sessionActivaBuscar);

		if (sessionActivaBuscar.getNavegador() != null) {

			if (!sessionActivaBuscar.getNavegador().equals(navegadorUsuario)) {
				return ResponseEntity.ok(new ResponseSp("-8", "El usuario ya esta logueado en el navegador: "
						+ sessionActivaBuscar.getNavegador() + ", por favor cierre session en el navegador"));
			}
		}

		String mirarIpCaptura = getClientIP(request);

		PwaSesionesActivas sessionActiva = PwaSesionesActivas.builder()
				.sesionActiva("SI")
				.navegador(navegadorUsuario)
				.usuarioSipac(usuarioConectado)
				.aplicacion("SIGIC MOVIL - PWA")
				.fechaConexion(new Date())
				.ipConexion(mirarIpCaptura).build();

		userService.registroDatosSession(sessionActiva);
		
		// Determinar en que SO estamos
		String so = System.getProperty("os.name");

		System.out.println("*************************************************");
		System.out.println("                                                   ");
		System.out.println("Por favor pasarnos el dato señor Faber: " + so);
		System.out.println("Por favor pasarnos el dato señor Faber: " + mirarIpCaptura);
		System.out.println("                                                   ");
		System.out.println("*************************************************");

		if (!usuarioConectado.equals("PRUEBA.PRUEBA")) {
			// Autenticación LDAP
			boolean contrasenia = false;
			String cedulaOID = userService.autenticarUsuarioOID(usuarioConectado, loginRequest.getContrasenia());

			System.out.println("cedulaOID: " + cedulaOID);
			Long cedulaLdap = 0L;

			if (!cedulaOID.equals("Fallido")) {
				// Se convierte la cedula de String a Long
				cedulaLdap = Long.parseLong(cedulaOID);
			}

			if (cedulaOID.equals("Fallido")) {
				contrasenia = false;
				return ResponseEntity.ok(new ResponseSp("-5", "Por favor verifique el password digitado."));
			} else if (cedulaLdap.equals(porUsuarioPwa.getIdentificacion())) {
				Long numIntentosFallidos = 0L;
				try {
					System.out.println("entro a generar jwt");

					EmpleadosSipac user = new EmpleadosSipac();
					contrasenia = true;

					user.setIdentificacion(Long.parseLong(cedulaOID));
					user.setUsuarioSipac(usuarioConectado);

					String jwt = jwtUtil.generateJwtTokenLdap(user);

					ResponseEntity<?> respuesta = userService.enviarCorreoLogueo(usuarioConectado, mirarIpCaptura);
					System.out.println("Se envia correo: " + respuesta);

					return ResponseEntity.ok(new JwtResponse(jwt, Long.valueOf(porUsuarioPwa.getConsecutivo()),
							Long.valueOf(porUsuarioPwa.getUndeCodigoSipac()), porUsuarioPwa.getUnidad(),
							porUsuarioPwa.getNombres(), porUsuarioPwa.getIdentificacion(),
							porUsuarioPwa.getUsuarioSipac(), porUsuarioPwa.getCorreoElectronico(),
							porUsuarioPwa.getActivo(), porUsuarioPwa.getAutorizado(), roles, tiempoTimeOut,
							porUsuarioPwa.getRegional(), porUsuarioPwa.getDescripcionGrupo(), mirarIpCaptura, so));
				} catch (Exception e) {
					System.out.println("Error de logueooo: " + e.getMessage());
					String error = e.getMessage();
					String mensaje = null;
					String code = null;

					if (error.equals("Bad credentials")) {
						mensaje = "Contraseña invalidad.";
						code = "-6";
					}
					return ResponseEntity.ok(new ResponseSp(code, mensaje));
				}
			}
		} else {
			contraseniaLdap = true;
		}

		if (contraseniaLdap) {
			try {
				// autenticar con spring boot
				Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(usuarioConectado, loginRequest.getContrasenia()));

				// adminUsuariosServiceupdateBloqueoCuenta
				SecurityContextHolder.getContext().setAuthentication(authentication);
				String jwt = jwtUtil.generarJsonWebToken(authentication);

				// ResponseEntity<?> respuesta = userService.enviarCorreoLogueo(usuarioConectado, mirarIpCaptura);
				// System.out.println("Se envia correo: " + respuesta);

				return ResponseEntity.ok(new JwtResponse(jwt, Long.valueOf(porUsuarioPwa.getConsecutivo()),
						Long.valueOf(porUsuarioPwa.getUndeCodigoSipac()), porUsuarioPwa.getUnidad(),
						porUsuarioPwa.getNombres(), porUsuarioPwa.getIdentificacion(), porUsuarioPwa.getUsuarioSipac(),
						porUsuarioPwa.getCorreoElectronico(), porUsuarioPwa.getActivo(), porUsuarioPwa.getAutorizado(),
						roles, tiempoTimeOut, porUsuarioPwa.getRegional(), porUsuarioPwa.getDescripcionGrupo(), mirarIpCaptura, so));
			} catch (Exception e) {
				Long numIntentosFallidos = 0L;
				System.out.println("Error de logueooo: " + e.getMessage());
				String error = e.getMessage();
				String mensaje = null;
				String code = null;

				if (error.equals("Bad credentials")) {
					mensaje = "Contraseña invalida.";
					code = "-6";
				}
				return ResponseEntity.ok(new ResponseSp(code, mensaje));
			}
		}
		return null;
	}

	@GetMapping(value = "/piePaginaInicioPagina", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> piePaginaInicioPagina() {
		return userService.piePaginaInicioPagina();
	}

	@DeleteMapping(value = "/cerrarSession", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> cerrarSession(@RequestBody PwaSesionesActivas pwaSesionesActivas) {
		return userService.cerrarSession(pwaSesionesActivas);
	}

	public String getClientIP(HttpServletRequest request) {
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		System.out.println("ipAddress: " + ipAddress);

		String xRealIp = request.getHeader("X-Real-IP");
		System.out.println("xRealIp: " + xRealIp);

		String xForwardedHost = request.getHeader("X-Forwarded-Host");
		System.out.println("xForwardedHost: " + xForwardedHost);

		if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// Si la IP es localhost, obtén la dirección IP de la máquina local
				try {
					InetAddress inetAddress = InetAddress.getLocalHost();
					ipAddress = inetAddress.getHostAddress();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
			}
		} else {
			// Si la IP viene a través de un proxy o balanceador de carga, toma la primera
			// dirección IP de la lista
			int index = ipAddress.indexOf(",");
			if (index > 0) {
				ipAddress = ipAddress.substring(0, index);
			}
		}

		System.out.println("IP final: " + ipAddress);
		return ipAddress;
	}

}