package co.gov.policia.pwa.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchResult;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.entity.PwaSesionesActivas;
import co.gov.policia.pwa.entity.SbParametros;
import co.gov.policia.pwa.entity.VwAdmUsuarioPerfil;
import co.gov.policia.pwa.entity.VwPwaAdminUsuarios;
import co.gov.policia.pwa.entity.VwPwaPerfilUsuarios;
import co.gov.policia.pwa.payload.response.ResponseSp;
import co.gov.policia.pwa.payload.response.SbParametrosResponse;
import co.gov.policia.pwa.service.UserService;

@Service
public class UserServiceImpl extends AbstractService implements UserService {

    @SuppressWarnings({ "unchecked", "unused" })
    @Override
    @Transactional
    public VwPwaAdminUsuarios buscarPwa(String usuarioEmpresarial) {
        List<VwPwaAdminUsuarios> listadoVwPwaAdminUsuarios = new ArrayList<>();
        VwPwaAdminUsuarios vwPwaAdminUsuarios = null;
        String code = " ";
        String mensaje = " ";

        Query q = em.createNativeQuery("select * from VW_PWA_ADMIN_USUARIOS where usuario_sipac = ?",
                VwPwaAdminUsuarios.class);
        q.setParameter(1, usuarioEmpresarial);

        listadoVwPwaAdminUsuarios = q.getResultList();
        System.out.println("USUARIO: " + listadoVwPwaAdminUsuarios);
        System.out.println("Tamaño de la lista: " + listadoVwPwaAdminUsuarios.size());

        if (listadoVwPwaAdminUsuarios.size() > 0) {
            code = "0";
            vwPwaAdminUsuarios = listadoVwPwaAdminUsuarios.get(0);
            mensaje = "Se ha encontrado el usuario";
        } else {
            code = "2";
            mensaje = "No se ha encontrado el usuario";
        }
        return vwPwaAdminUsuarios;
    }
    
    @SuppressWarnings({ "unused", "unchecked" })
    @Override
    @Transactional
    public VwPwaAdminUsuarios buscarPwa2(String usuarioEmpresarial) {
        System.out.println("usuarioEmpresarial: " + usuarioEmpresarial);
        List<VwPwaAdminUsuarios> listadoVwPwaAdminUsuarios = new ArrayList<>();
        VwPwaAdminUsuarios vwPwaAdminUsuarios = null;
        String code = " ";
        String mensaje = " ";
        BigDecimal usuarioAutorizado;
        Long userAutorizado = 0L;

        System.out.println("sigooo por la busqueda 2");
        
        String consultaSql = "select * from VW_PWA_ADMIN_USUARIOS where usuario_sipac = '" + usuarioEmpresarial + "'";
        System.out.println("consultaSql: " + consultaSql);
        
        Query q = em.createNativeQuery(consultaSql, VwPwaAdminUsuarios.class);
        //q.setParameter(1, usuarioEmpresarial);

        listadoVwPwaAdminUsuarios = q.getResultList();
        System.out.println("USUARIO: " + listadoVwPwaAdminUsuarios);

        if (listadoVwPwaAdminUsuarios.size() > 0) {
            code = "0";
            vwPwaAdminUsuarios = listadoVwPwaAdminUsuarios.get(0);
            mensaje = "Se ha encontrado el usuario";
        } else {
            code = "2";
            mensaje = "No se ha encontrado el usuario";
            System.out.println("Entro al elseeeee");
        }
        return vwPwaAdminUsuarios;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public String grupoUsuario(String usuarioEmpresarial) {

        List<String> resultadoConsulta = new ArrayList<>();

        String r = "";

        Query q = em.createNativeQuery("select ui.grupo from empleados_sipac es,\r\n"
                + "ter_usuarios_interpol ui\r\n"
                + "where es.identificacion=ui.identificacion\r\n"
                + "and ui.usuario_sipac=?");

        q.setParameter(1, usuarioEmpresarial);

        resultadoConsulta = q.getResultList();

        if (resultadoConsulta.size() > 0) {
            r = resultadoConsulta.get(0);
        } else {
            r = "NO TIENE GRUPO";
        }
        return r;
    }

    @SuppressWarnings("unused")
    @Override
    @Transactional
    public VwAdmUsuarioPerfil buscarUsuarioPorPerfil(String usuarioEmpresarial) {
        List<VwAdmUsuarioPerfil> listadoVsidUsuaPerfil = new ArrayList<>();
        VwAdmUsuarioPerfil vsidUsuaPerfil = null;
        String code = " ";
        String mensaje = " ";

        TypedQuery<VwAdmUsuarioPerfil> q = em.createQuery(
                "SELECT u FROM VwAdmUsuarioPerfil u WHERE u.usuarioEmpresarial=:usuarioEmpresarial",
                VwAdmUsuarioPerfil.class);
        q.setParameter("usuarioEmpresarial", usuarioEmpresarial);

        listadoVsidUsuaPerfil = q.getResultList();

        if (listadoVsidUsuaPerfil.size() > 0) {
            code = "0";
            vsidUsuaPerfil = listadoVsidUsuaPerfil.get(0);
            mensaje = "Se ha encontrado el usuario";
        } else {
            code = "2";
            mensaje = "No se ha encontrado el usuario";
            System.out.println("Entro al elseeeee");
        }
        return vsidUsuaPerfil;
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<VwPwaAdminUsuarios> consultarUsuarioDependencia(String idUsuario) {
        List<VwPwaAdminUsuarios> listaVSidUsuarioApl = new ArrayList<VwPwaAdminUsuarios>();
        
        Query query = em.createNativeQuery("SELECT * FROM VW_PWA_ADMIN_USUARIOS WHERE USUARIO_SIPAC = ? ORDER BY NOMBRES ASC", VwPwaAdminUsuarios.class);
        query.setParameter(1, idUsuario);    
        
        listaVSidUsuarioApl = query.getResultList();
        return listaVSidUsuarioApl;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public String autenticarUsuarioOID(String pUserName, String pPassword) {

        String r = "Fallido";

        String ldapPrincipal = "cn=" + pUserName + ",cn=users,dc=policia,dc=gov,dc=co";

        try {
            // Set up the environment for creating the initial context
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://oud.policia.gov.co:389");

            // Authenticacion, usuario / password
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, ldapPrincipal);
            env.put(Context.SECURITY_CREDENTIALS, pPassword);
            env.put("com.sun.jndi.ldap.connect.pool", "true");

            DirContext ctx = new InitialDirContext(env);

            r = "Inicializado";

            Attributes matchAttrs = new BasicAttributes(true);
            String[] attrIDs = { "employeenumber" };

            matchAttrs.put(new BasicAttribute("uid", pUserName));

            NamingEnumeration answer = ctx.search("cn=users,dc=policia,dc=gov,dc=co", matchAttrs, attrIDs);

            while (answer.hasMore()) {
                SearchResult sr = (SearchResult) answer.next();
                System.out.println(">>>" + sr.getName());
                Attributes attrs = sr.getAttributes();

                Attribute cedula = (Attribute) attrs.get("employeenumber");
                System.out.println("CEDULA = " + cedula.get());

                r = cedula.get().toString();
            }

            System.out.println("pUserName: " + pUserName);
            System.out.println("r: " + r);
            ctx.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error en loguearse en Ldap: " + e.getMessage());
            System.out.println("Error en loguearse en Ldap111" + e.getLocalizedMessage());
        }
        return r;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public ArrayList<VwPwaPerfilUsuarios> obtenerObjetosUsuario(String usuario) {
        
        Query query = em.createNativeQuery("select * from vw_pwa_perfil_usuarios where usuario = ? ", VwPwaPerfilUsuarios.class);
        query.setParameter(1, usuario);
        
        ArrayList<VwPwaPerfilUsuarios> objetosPerfilUsuario = (ArrayList<VwPwaPerfilUsuarios>) query.getResultList();
        System.out.println("Perfiles - objetosPerfilUsuario: " + objetosPerfilUsuario);
        return objetosPerfilUsuario;

    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public ArrayList<VwAdmUsuarioPerfil> obtenerAppModuloUsuario(String usuario) {
        Query query = em.createNamedQuery("VwAdmUsuarioPerfil.findPorPerfilesAsignados", VwAdmUsuarioPerfil.class);
        query.setParameter("usuario", usuario);

        ArrayList<VwAdmUsuarioPerfil> objetosPerfilUsuario = (ArrayList<VwAdmUsuarioPerfil>) query.getResultList();
        System.out.println("Apps - objetosPerfilUsuario: " + objetosPerfilUsuario);
        return objetosPerfilUsuario;
    }

    @Override
    @Transactional
    public List<VwPwaAdminUsuarios> selectAllUsuarios() {
        TypedQuery<VwPwaAdminUsuarios> q = em.createQuery("SELECT u FROM VwPwaAdminUsuarios u", VwPwaAdminUsuarios.class);
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public VwPwaAdminUsuarios selectUserByUsername(String username) {
        List<VwPwaAdminUsuarios> listaUsuarios = new ArrayList<>();
        VwPwaAdminUsuarios vSidUsuarioApl = null;
        System.out.println("username: " + username);
        try {
            Query q = em.createQuery("SELECT t FROM VwPwaAdminUsuarios t WHERE t.usuarioSipac = :username",
            		VwPwaAdminUsuarios.class);
            q.setParameter("username", username);
            listaUsuarios = q.getResultList();
            if (listaUsuarios.size() > 0) {
                vSidUsuarioApl = listaUsuarios.get(0);
            }
        } catch (Exception ex) {
            System.out.println("Error al consulta: " + ex.getMessage());
        }
        return vSidUsuarioApl;
    }

    @Override
    @Transactional
    public ResponseEntity<?> enviarCorreoLogueo(String usuarioConexion, String mirarIpCaptura) {

        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("PK_PWA_CORREO_INICIO.PR_ENVIAR_MAIL_INICIO");

        storedProcedureQuery.registerStoredProcedureParameter("P_USUARIO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("P_IP_CAPTURA", String.class, ParameterMode.IN);

        storedProcedureQuery.registerStoredProcedureParameter("P_RESPUESTA", String.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter("P_DESC_RESULTADO", String.class, ParameterMode.OUT);

        storedProcedureQuery.setParameter("P_USUARIO", usuarioConexion);
        System.out.println("P_USUARIO: " + usuarioConexion);
        
        storedProcedureQuery.setParameter("P_IP_CAPTURA", mirarIpCaptura.trim());
        System.out.println("P_IP_CAPTURA: " + mirarIpCaptura.trim());

        storedProcedureQuery.execute();

        String response = (String) storedProcedureQuery.getOutputParameterValue("P_RESPUESTA");
        System.out.println("response: " + response);

        String responseDescription = (String) storedProcedureQuery.getOutputParameterValue("P_DESC_RESULTADO");
        System.out.println("responseDescription: " + responseDescription);

        return ResponseEntity.ok(new ResponseSp(response, responseDescription));
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public ResponseEntity<?> piePaginaInicioPagina() {
        List<SbParametros> listadoSbParametros = new ArrayList<>();
        List<SbParametros> sbParametros = null;
        Long code = null;
        String mensaje = "";
        try {

            Query q = em.createNativeQuery(
                    "select * from sb_parametros where aplicacion = 'SIPAC' AND PARAMETRO = 'PIE_PAGINA1'", SbParametros.class);

            listadoSbParametros = q.getResultList();
            if (listadoSbParametros.size() > 0) {
                code = 0L;
                sbParametros = listadoSbParametros;
                mensaje = "Se ha encontrado informacion";
            } else {
                code = 2L;
                mensaje = "No se ha encontrado información.";
                sbParametros = new ArrayList<SbParametros>();
            }
            Long totalResultados = (long) listadoSbParametros.size();
            return ResponseEntity.ok(new SbParametrosResponse(sbParametros, code, mensaje, totalResultados));
        } catch (Exception ex) {
            System.out.println("Error al consultar por numeroHecho: " + ex.getMessage());
            return ResponseEntity.ok(ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public SbParametros buscarEnSbParametros(String aplicacion, String parametro) {
        List<SbParametros> listaSbParametros = new ArrayList<>();
        SbParametros sbParametros = null;
        System.out.println("aplicacion: " + aplicacion);
        System.out.println("parametro: " + parametro);
        try {
            Query q = em.createNativeQuery("select * from sb_parametros where aplicacion = ? AND PARAMETRO = ?",
                    SbParametros.class);
            
            q.setParameter(1, aplicacion);
            q.setParameter(2, parametro);
            
            listaSbParametros = q.getResultList();
            if (listaSbParametros.size() > 0) {
                sbParametros = listaSbParametros.get(0);
            }
        } catch (Exception ex) {
            System.out.println("Error al consulta: " + ex.getMessage());
        }
        return sbParametros;
    }
          
    @Override
	@Transactional
	public ResponseEntity<?> registroDatosSession(PwaSesionesActivas pwaSesionesActivas) {
    	
		StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("PK_PWA_SEGURIDAD.PR_PWA_GUARDAR_DATOS_CONEXION_USUARIO");

		storedProcedureQuery.registerStoredProcedureParameter("I_SESION_ACTIVA", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_NAVEGADOR", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_USUARIO_SIPAC", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_APLICACION", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_FECHA_CONEXION", Date.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_IP_CONEXION", String.class, ParameterMode.IN);

		storedProcedureQuery.registerStoredProcedureParameter("I_CONSECUTIVO", Long.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("I_RESPUESTA", Long.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("I_DESC_RESULTADO", String.class, ParameterMode.OUT);

		storedProcedureQuery.setParameter("I_SESION_ACTIVA", pwaSesionesActivas.getSesionActiva());
		System.out.println("I_SESION_ACTIVA: " + pwaSesionesActivas.getSesionActiva());
		
		storedProcedureQuery.setParameter("I_NAVEGADOR", pwaSesionesActivas.getNavegador().trim().toUpperCase());
		System.out.println("I_NAVEGADOR: " + pwaSesionesActivas.getNavegador().trim().toUpperCase());
		
		storedProcedureQuery.setParameter("I_USUARIO_SIPAC", pwaSesionesActivas.getUsuarioSipac());
		System.out.println("I_USUARIO_SIPAC: " + pwaSesionesActivas.getUsuarioSipac());
		
		storedProcedureQuery.setParameter("I_APLICACION", pwaSesionesActivas.getAplicacion());
		System.out.println("I_APLICACION: " + pwaSesionesActivas.getAplicacion());
		
		storedProcedureQuery.setParameter("I_FECHA_CONEXION", pwaSesionesActivas.getFechaConexion());
		System.out.println("I_FECHA_CONEXION: " + pwaSesionesActivas.getFechaConexion());
		
		storedProcedureQuery.setParameter("I_IP_CONEXION", pwaSesionesActivas.getIpConexion());
		System.out.println("I_IP_CONEXION: " + pwaSesionesActivas.getIpConexion());

		storedProcedureQuery.execute();
		
		long responseConsecutivo = (Long) storedProcedureQuery.getOutputParameterValue("I_CONSECUTIVO");
		System.out.println("responseConsecutivo: " + responseConsecutivo);

		long response = (long) storedProcedureQuery.getOutputParameterValue("I_RESPUESTA");
		System.out.println("Cod de respuesta: " + response);

		String descResultado = (String) storedProcedureQuery.getOutputParameterValue("I_DESC_RESULTADO");
		System.out.println("Descripcion de la respuesta: " + descResultado);
		

		return ResponseEntity.ok(new ResponseSp(String.valueOf(response), descResultado));
	}
    
    @SuppressWarnings({ "unchecked", "unused" })
    @Override
    @Transactional
    public PwaSesionesActivas buscarSessionActivaByUsuario(String usuarioEmpresarial) {
        List<PwaSesionesActivas> listadoPwaSesionesActivas = new ArrayList<>();
        PwaSesionesActivas pwaSesionesActivas = null;
        Long code = null;
        String mensaje = " ";

        Query q = em.createNativeQuery("select * from PWA_SESIONES_ACTIVAS where usuario_sipac = ? AND sesion_activa = 'SI' AND fecha_desconexion IS NULL",
        		PwaSesionesActivas.class);
        q.setParameter(1, usuarioEmpresarial);

        listadoPwaSesionesActivas = q.getResultList();

        if (listadoPwaSesionesActivas.size() > 0) {
            code = 0L;
            pwaSesionesActivas = listadoPwaSesionesActivas.get(0);
            mensaje = "Se ha encontrado el usuario";
        } else {
            code = 2L;
            mensaje = "No se ha encontrado el usuario";
            pwaSesionesActivas = new PwaSesionesActivas(); 
        }
        return pwaSesionesActivas;
    }

	@Override
	public ResponseEntity<?> cerrarSession(PwaSesionesActivas pwaSesionesActivas) {

		StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("PK_PWA_SEGURIDAD.PR_PWA_CERRAR_SESSION");

		storedProcedureQuery.registerStoredProcedureParameter("D_USUARIO_SIPAC", String.class, ParameterMode.IN);
		
		storedProcedureQuery.registerStoredProcedureParameter("D_RESPUESTA", Long.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("D_DESC_RESULTADO", String.class, ParameterMode.OUT);

		storedProcedureQuery.setParameter("D_USUARIO_SIPAC", pwaSesionesActivas.getUsuarioSipac());
		System.out.println("D_USUARIO_SIPAC: " + pwaSesionesActivas.getUsuarioSipac());
		
		storedProcedureQuery.execute();

		long response = (long) storedProcedureQuery.getOutputParameterValue("D_RESPUESTA");
		System.out.println("Cod de respuesta: " + response);

		String descResultado = (String) storedProcedureQuery.getOutputParameterValue("D_DESC_RESULTADO");
		System.out.println("Descripcion de la respuesta: " + descResultado);
		
		return ResponseEntity.ok(new ResponseSp(String.valueOf(response), descResultado));
	}
	
	@Override
    @Transactional
    public Long conteoSessionesActivas() {
        
        Long r = null;
        
        String usuarioConexion = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("usuarioConexion en el controlador: " + usuarioConexion);
        
        try {
            Query q = em.createNativeQuery("select COUNT(*) from PWA_SESIONES_ACTIVAS where usuario_sipac = ? AND sesion_activa = 'SI'");
            
            q.setParameter(1, usuarioConexion);
            
            BigDecimal conteoTotalBigDecimal = (BigDecimal) q.getSingleResult();
            String conteoTotalString = conteoTotalBigDecimal.toString();  		
			long conteoTotalLong = Long.parseLong(conteoTotalString);  
            System.out.println("conteoTotalLong: " + conteoTotalLong);
            
        } catch (Exception ex) {
            System.out.println("Error al consultar: " + ex.getMessage());

        }
        return r;
    }
    
}