package co.gov.policia.pwa.service.impl;

import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.entity.EmpleadosSipac;
import co.gov.policia.pwa.entity.AdmPwaPerfil;
import co.gov.policia.pwa.entity.VwAdmUsuarioPerfil;
import co.gov.policia.pwa.payload.response.EmpleadosSipacResponse;
import co.gov.policia.pwa.service.AdminUsuariosService;

@Service
public class AdminUsuariosServiceImpl extends AbstractService implements AdminUsuariosService {

	@SuppressWarnings("unchecked")
    @Override
	@Transactional
	public List<AdmPwaPerfil> selectAllPerfiles() {
		Query q = em.createQuery("SELECT u FROM AdmPwaPerfil u", AdmPwaPerfil.class);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
    @Override
	@Transactional
	public List<VwAdmUsuarioPerfil> selectUsuarioPerfil(String usuario) {
		Query query = em.createNativeQuery(
				"select * from VW_ADM_SIG_USUARIO_PERFIL where usuario = ? AND tipo_consulta = 'I' AND ESTADO = 'A'",
				VwAdmUsuarioPerfil.class);
		query.setParameter(1, usuario);
		List<VwAdmUsuarioPerfil> objetosPerfilUsuario = query.getResultList();

		return objetosPerfilUsuario;
	}

	@Override
	@Transactional
	public String asignarPerfilesUsuario(String indica, String usuarioEmpresarial, Long nUsuarioID, Long indPerfil) {

		String userName = SecurityContextHolder.getContext().getAuthentication().getName();

		StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("PK_SIG_SEGURIDAD_ROLES.PR_SIG_USU_PERFIL");
		storedProcedureQuery.registerStoredProcedureParameter("INDICA", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("P_USUARIO_EMPRESARIAL", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("P_NUSUARIOS_ID", Long.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("P_IND_PERFIL", Long.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("P_USUARIO_GRABA", String.class, ParameterMode.IN);

		storedProcedureQuery.registerStoredProcedureParameter("P_RESPUESTA", String.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("P_DESC_RESULTADO", String.class, ParameterMode.OUT);

		storedProcedureQuery.setParameter("INDICA", indica);
		System.out.println("INDICA: " + indica);
		
		storedProcedureQuery.setParameter("P_USUARIO_EMPRESARIAL", usuarioEmpresarial);
		System.out.println("P_USUARIO_EMPRESARIAL: " + usuarioEmpresarial);
		
		storedProcedureQuery.setParameter("P_NUSUARIOS_ID", nUsuarioID);
		System.out.println("P_NUSUARIOS_ID: " + nUsuarioID);
		
		storedProcedureQuery.setParameter("P_IND_PERFIL", indPerfil);
		System.out.println("P_IND_PERFIL: " + indPerfil);
		
		storedProcedureQuery.setParameter("P_USUARIO_GRABA", userName);
		System.out.println("P_USUARIO_GRABA: " + userName);
		
		System.out.println("ENTRA PROCE asignarPerfilesUsuario");

		storedProcedureQuery.execute();

		String response = (String) storedProcedureQuery.getOutputParameterValue("P_RESPUESTA");
		String responseDescResultado = (String) storedProcedureQuery.getOutputParameterValue("P_DESC_RESULTADO");

		System.out.println("Codigo de respuesta de asignacion de perfiles: " + response);
		System.out.println("Respuesta de asignacion del Perfiles: " + responseDescResultado);
		return response;
	}

	@Override
	@Transactional
	public EmpleadosSipacResponse infoUsuarios(EmpleadosSipac usuarioSipac) {

		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		EmpleadosSipacResponse empleadosRespuesta = new EmpleadosSipacResponse();
		EmpleadosSipac usuarioSipacCon = new EmpleadosSipac();

		StoredProcedureQuery storedProcedureQuery = em
				.createStoredProcedureQuery("PK_SIG_SEGURIDAD_ROLES.PR_SIG_USUARIOS_CONS");

		storedProcedureQuery.registerStoredProcedureParameter("C_IDENTIFICACION", Long.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("C_USUARIO_SIPAC", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("C_USUARIO_CREADOR", String.class, ParameterMode.IN);

		storedProcedureQuery.registerStoredProcedureParameter("C_IDENTIFICACION_SIPAC", Long.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("C_NOMBRES_EMPLEADO", String.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("C_GRAD_ALFABETICO", Long.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("C_ACTIVO", String.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("C_CORREO_ELECTRONICO", String.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("C_USUARIO_EMPRESARIAL_SIPAC", String.class, ParameterMode.OUT);

		storedProcedureQuery.registerStoredProcedureParameter("C_RAZON_OPERACION", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("C_RAZON_OBSERVACION", String.class, ParameterMode.IN);

		storedProcedureQuery.registerStoredProcedureParameter("C_RESPUESTA", String.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("C_DESC_RESULTADO", String.class, ParameterMode.OUT);

		storedProcedureQuery.setParameter("C_IDENTIFICACION", usuarioSipac.getIdentificacion());

		storedProcedureQuery.setParameter("C_USUARIO_SIPAC", usuarioSipac.getUsuarioSipac());

		storedProcedureQuery.setParameter("C_USUARIO_CREADOR", userName);

		storedProcedureQuery.execute();

		Long identificacionSipac = (Long) storedProcedureQuery.getOutputParameterValue("C_IDENTIFICACION_SIPAC");

		String nombresEmpleado = (String) storedProcedureQuery.getOutputParameterValue("C_NOMBRES_EMPLEADO");

		Long gradAlfabetico = (Long) storedProcedureQuery.getOutputParameterValue("C_GRAD_ALFABETICO");

		String activo = (String) storedProcedureQuery.getOutputParameterValue("C_ACTIVO");

		String correoElectronico = (String) storedProcedureQuery.getOutputParameterValue("C_CORREO_ELECTRONICO");

		String usuarioEmpresarialSipac = (String) storedProcedureQuery.getOutputParameterValue("C_USUARIO_EMPRESARIAL_SIPAC");

		String response = (String) storedProcedureQuery.getOutputParameterValue("C_RESPUESTA");
		System.out.println("Cod de respuesta: " + response);

		String descResultado = (String) storedProcedureQuery.getOutputParameterValue("C_DESC_RESULTADO");
		System.out.println("Descripcion de la respuesta: " + descResultado);

		usuarioSipacCon.setIdentificacion(identificacionSipac);
		usuarioSipacCon.setNombres(nombresEmpleado);
		usuarioSipacCon.setGradAlfabetico(gradAlfabetico);
		usuarioSipacCon.setActivo(activo);
		usuarioSipacCon.setCorreoElectronico(correoElectronico);
		usuarioSipacCon.setUsuarioSipac(usuarioEmpresarialSipac);
		empleadosRespuesta.setUsuario(usuarioSipacCon);
		empleadosRespuesta.setCode(response);
		empleadosRespuesta.setMessage(descResultado);
		return empleadosRespuesta;

	}
	
	@SuppressWarnings("unchecked")
    @Override
	public List<VwAdmUsuarioPerfil> listaAllPerfiles(String username) {
				Query query = em.createNativeQuery("select * from VW_ADM_SIG_USUARIO_PERFIL\r\n"
				+ "where usuario= ?", VwAdmUsuarioPerfil.class);
				query.setParameter(1, username);
		List<VwAdmUsuarioPerfil> listaPerfilesUsuario = query.getResultList();

		return listaPerfilesUsuario;
	}

	@Override
	public List<VwAdmUsuarioPerfil> listaPerfilesNoAsignados(String username) {
		TypedQuery<VwAdmUsuarioPerfil> query = em
				.createNamedQuery("VwAdmUsuarioPerfil.findPorPerfilesNoAsignados", VwAdmUsuarioPerfil.class);
		query.setParameter("usuario", username);
		List<VwAdmUsuarioPerfil> listaPerfilesUsuario = query.getResultList();

		return listaPerfilesUsuario;
	}
	
	@SuppressWarnings("unchecked")
    @Override
	public List<VwAdmUsuarioPerfil> listaPerfilesAsignados(String username) {
		
		Query query = em.createNativeQuery("select * from VW_ADM_SIG_USUARIO_PERFIL v \r\n"
				+ "WHERE v.usuario = ? \r\n"
				+ "AND v.tipo_consulta = 'I' \r\n"
				+ "AND v.estado = 'A' ORDER BY v.nom_perfil", VwAdmUsuarioPerfil.class);
		query.setParameter(1, username);
		List<VwAdmUsuarioPerfil> listaPerfilesUsuario = query.getResultList();

		return listaPerfilesUsuario;
	}

}
