package co.gov.policia.pwa.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;
import co.gov.policia.pwa.entity.VwPwaAdminUsuarios;
import co.gov.policia.pwa.entity.VwPwaFranquicia;
import co.gov.policia.pwa.service.UserService;
import co.gov.policia.pwa.service.VwPwaFranquiciaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/vwpwafranquicia")
public class VwPwaFranquiciaController {

	@Autowired
	VwPwaFranquiciaService vwPwaFranquiciaService;
	
	@Autowired
    UserService userService;

	@PostMapping(value = "/insertFranquiciaPermisos", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> insertVwPwaFranquicia(@RequestBody VwPwaFranquicia vwPwaFranquicia) {

		String usuarioConexion = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("usuarioConexion: " + usuarioConexion);
		
		VwPwaAdminUsuarios porUsuarioPwa = new VwPwaAdminUsuarios();
		porUsuarioPwa = userService.buscarPwa(usuarioConexion);
		
		long undeCodigoSipac = porUsuarioPwa.getUndeCodigoSipac();

		return vwPwaFranquiciaService.insertVwPwaFranquicia(vwPwaFranquicia, usuarioConexion, undeCodigoSipac);
	}
	
	@GetMapping(value = "/tipoPermisoFranquiciaOtorgada", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> tipoPermisoFranquiciaOtorgada() {
        return vwPwaFranquiciaService.tipoPermisoFranquiciaOtorgada();
    }
	
	@GetMapping(value = "/tipoPermisoOFranquicia", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> tipoPermisoOFranquicia(@RequestParam String codigoFranquicia) {
        return vwPwaFranquiciaService.tipoPermisoOFranquicia(codigoFranquicia);
    }
	
	@GetMapping(value = "/totalDiasPermisosFranquicias", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> totalDiasPermisosFranquicias() {
        return vwPwaFranquiciaService.totalDiasPermisosFranquicias();
    }

}