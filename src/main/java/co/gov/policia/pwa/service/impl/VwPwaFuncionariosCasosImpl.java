package co.gov.policia.pwa.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import co.gov.policia.pwa.entity.BuscarNoticiaCriminal;
import co.gov.policia.pwa.entity.IdentificacionNombreUnidad;
import co.gov.policia.pwa.entity.VwCasosFuncionarios;
import co.gov.policia.pwa.entity.VwPwaAdminUsuarios;
import co.gov.policia.pwa.entity.VwPwaFuncionariosCasos;
import co.gov.policia.pwa.entity.VwPwaValidaVroUnico;
import co.gov.policia.pwa.payload.response.BuscarNoticiaCriminalResponse;
import co.gov.policia.pwa.payload.response.IdentificacionNombreUnidadResponse;
import co.gov.policia.pwa.payload.response.VwCasosFuncionariosResponse;
import co.gov.policia.pwa.payload.response.VwPwaAdminUsuariosResponse;
import co.gov.policia.pwa.payload.response.VwPwaFuncionariosCasosResponse;
import co.gov.policia.pwa.payload.response.VwPwaValidaVroUnicoResponse;
import co.gov.policia.pwa.service.VwPwaFuncionariosCasosService;
import org.springframework.stereotype.Service;
import javax.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.Query;

@Service
public class VwPwaFuncionariosCasosImpl extends AbstractService implements VwPwaFuncionariosCasosService {

	private static final long serialVersionUID = 1L;

	@Lazy
	@Autowired
	VwPwaFuncionariosCasosService vwPwaFuncionariosCasosService;

	@Override
	@Transactional
	public ResponseEntity<?> insertVwPwaFuncionar(VwPwaFuncionariosCasos vwPwaFuncionariosCasos,
			String usuarioConexion) {

		StoredProcedureQuery storedProcedureQuery = em
				.createStoredProcedureQuery("PK_PWA_VW_PWA_FUNCIONARIO_CASOS.PR_VWPWAFUNCIONARK_INS");

		storedProcedureQuery.registerStoredProcedureParameter("I_UNDE_CODIGO", Long.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_USUARIO_CREADOR", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_CONS_CASO", Long.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_CONS_EMP_SIPAC", Long.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_ESTADO", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_NOTIFICACION", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_CONS_EMP_ASIGNADO_A", Long.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_TIPO_NOVEDAD", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_FECHA_FIN", Date.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_FECHA_INICIO", Date.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_ROL", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_MOTIVO_ESTADO", String.class, ParameterMode.IN);

		storedProcedureQuery.registerStoredProcedureParameter("I_CONSECUTIVO", Long.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("I_RESPUESTA", String.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("I_DESC_RESULTADO", String.class, ParameterMode.OUT);

		storedProcedureQuery.setParameter("I_UNDE_CODIGO", vwPwaFuncionariosCasos.getUndeCodigo());
		System.out.println("I_UNDE_CODIGO: " + vwPwaFuncionariosCasos.getUndeCodigo());

		storedProcedureQuery.setParameter("I_USUARIO_CREADOR", usuarioConexion);
		System.out.println("I_USUARIO_CREADOR: " + usuarioConexion);

		storedProcedureQuery.setParameter("I_CONS_CASO", vwPwaFuncionariosCasos.getConsCaso());
		System.out.println("I_CONS_CASO: " + vwPwaFuncionariosCasos.getConsCaso());

		storedProcedureQuery.setParameter("I_CONS_EMP_SIPAC", vwPwaFuncionariosCasos.getConsEmpSipac());
		System.out.println("I_CONS_EMP_SIPAC: " + vwPwaFuncionariosCasos.getConsEmpSipac());

		storedProcedureQuery.setParameter("I_ESTADO", vwPwaFuncionariosCasos.getEstado());
		System.out.println("I_ESTADO: " + vwPwaFuncionariosCasos.getEstado());

		storedProcedureQuery.setParameter("I_NOTIFICACION", vwPwaFuncionariosCasos.getNotificacion());
		System.out.println("I_NOTIFICACION: " + vwPwaFuncionariosCasos.getNotificacion());

		storedProcedureQuery.setParameter("I_CONS_EMP_ASIGNADO_A", vwPwaFuncionariosCasos.getConsEmpAsignadoA());
		System.out.println("I_CONS_EMP_ASIGNADO_A: " + vwPwaFuncionariosCasos.getConsEmpAsignadoA());

		storedProcedureQuery.setParameter("I_TIPO_NOVEDAD", vwPwaFuncionariosCasos.getTipoNovedad());

		storedProcedureQuery.setParameter("I_FECHA_FIN", vwPwaFuncionariosCasos.getFechaFin());

		storedProcedureQuery.setParameter("I_FECHA_INICIO", vwPwaFuncionariosCasos.getFechaInicio());

		storedProcedureQuery.setParameter("I_ROL", vwPwaFuncionariosCasos.getRol());

		storedProcedureQuery.setParameter("I_MOTIVO_ESTADO", vwPwaFuncionariosCasos.getMotivoEstado());

		storedProcedureQuery.execute();

		String response = (String) storedProcedureQuery.getOutputParameterValue("I_RESPUESTA");

		String responseDescription = (String) storedProcedureQuery.getOutputParameterValue("I_DESC_RESULTADO");

		long responseConsecutivo = (Long) storedProcedureQuery.getOutputParameterValue("I_CONSECUTIVO");

		return ResponseEntity
				.ok(new VwPwaFuncionariosCasosResponse(null, response, responseDescription, responseConsecutivo));
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> buscarByIdentificacionFuncionarios(@RequestParam Long identificacion) {
		List<IdentificacionNombreUnidad> listadoIdentificacionNombreUnidad = new ArrayList<>();
		List<IdentificacionNombreUnidad> identificacionNombreUnidad = null;
		Long code = null;
		String mensaje = "";

		try {

			Query q = em.createNativeQuery(
					"select consecutivo, identificacion, gr_nombre, d_unde_codigo_sipac from vw_admon_usuarios where identificacion = ?");

			q.setParameter(1, identificacion);

			List<Object[]> lstItems = (List<Object[]>) q.getResultList();

			int i = 0;
			for (Object[] obj : lstItems) {
				IdentificacionNombreUnidad identificacionNombreUnidad11 = new IdentificacionNombreUnidad();
				if (i < lstItems.size()) {
					identificacionNombreUnidad11
							.setConsecutivo(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
					identificacionNombreUnidad11
							.setIdentificacion(Long.parseLong(obj[1] == null ? null : obj[1].toString()));
					identificacionNombreUnidad11.setGrNombre(obj[2] == null ? null : obj[2].toString());
					identificacionNombreUnidad11.setDUndeCodigoSipac(obj[3] == null ? null : obj[3].toString());
				}
				listadoIdentificacionNombreUnidad.add(identificacionNombreUnidad11);
				i = i + 1;
			}
			if (listadoIdentificacionNombreUnidad.size() > 0) {
				code = 0L;
				identificacionNombreUnidad = listadoIdentificacionNombreUnidad;
				mensaje = "Se ha encontrado informacion";
			} else {
				code = 2L;
				mensaje = "No se ha encontrado información.";
				identificacionNombreUnidad = new ArrayList<IdentificacionNombreUnidad>();
			}
			Long totalResultados = (long) listadoIdentificacionNombreUnidad.size();
			return ResponseEntity.ok(
					new IdentificacionNombreUnidadResponse(identificacionNombreUnidad, code, mensaje, totalResultados));
		} catch (Exception ex) {

			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> buscarNoticiaCriminal(String nroUnico) {
		List<BuscarNoticiaCriminal> listadoBuscarNoticiaCriminal = new ArrayList<>();
		List<BuscarNoticiaCriminal> buscarNoticiaCriminal = null;
		Long code = null;
		String mensaje = "";

		try {

			Query q = em.createNativeQuery("select consecutivo, nro_unico from vw_pwa_valida_nro_unico where nro_unico = ?");
			q.setParameter(1, nroUnico.trim());

			List<Object[]> lstItems = (List<Object[]>) q.getResultList();

			int i = 0;
			for (Object[] obj : lstItems) {
				BuscarNoticiaCriminal buscarNoticiaCriminal11 = new BuscarNoticiaCriminal();
				if (i < lstItems.size()) {			
					buscarNoticiaCriminal11.setConsecutivo(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
					buscarNoticiaCriminal11.setNroUnico(obj[1] == null ? null : obj[1].toString());
				}
				listadoBuscarNoticiaCriminal.add(buscarNoticiaCriminal11);
				i = i + 1;
			}

			if (listadoBuscarNoticiaCriminal.size() > 0) {
				code = 0L;
				buscarNoticiaCriminal = listadoBuscarNoticiaCriminal;
				mensaje = "Se ha encontrado informacion";
			} else {
				code = 2L;
				mensaje = "No se ha encontrado información.";
				buscarNoticiaCriminal = new ArrayList<BuscarNoticiaCriminal>();
			}
			Long totalResultados = (long) listadoBuscarNoticiaCriminal.size();
			return ResponseEntity
					.ok(new BuscarNoticiaCriminalResponse(buscarNoticiaCriminal, code, mensaje, totalResultados));
		} catch (Exception ex) {

			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> buscarNoticiaCriminalFinal(String nroUnico, Long consecutivo) {
		List<VwCasosFuncionarios> listadoVwCasosFuncionarios = new ArrayList<>();
		List<VwCasosFuncionarios> buscarVwCasosFuncionarios = null;
		Long code = null;
		String mensaje = "";

		Query q = null;

		try {

			q = em.createNativeQuery("select * from VW_CASOS_FUNCIONARIOS where nro_unico = ? and consecutivo_empleado= ?",
					VwCasosFuncionarios.class);

			q.setParameter(1, nroUnico.trim());
			q.setParameter(2, consecutivo);

			listadoVwCasosFuncionarios = q.getResultList();

			if (listadoVwCasosFuncionarios.size() == 0) {
				q = em.createNativeQuery(
						"select * from VW_PWA_VALIDA_NRO_UNICO where nro_unico = ?",
						VwPwaValidaVroUnico.class);

				q.setParameter(1, nroUnico.trim());
				//q.setParameter(2, consecutivo);

				listadoVwCasosFuncionarios = q.getResultList();

				if (listadoVwCasosFuncionarios.size() > 0) {
					code = 0L;
					buscarVwCasosFuncionarios = listadoVwCasosFuncionarios;
					mensaje = "Se ha encontrado informacion";
				} else {
					code = -1L;
					buscarVwCasosFuncionarios = listadoVwCasosFuncionarios;
					mensaje = "El usuario no tiene permisos para ver la noticia criminal";
				}
			} else {
				code = 2L;
				mensaje = "No se ha encontrado información. Por favor verifique el No. Noticia Criminal.";
				buscarVwCasosFuncionarios = listadoVwCasosFuncionarios;
			}

			Long totalResultados = (long) listadoVwCasosFuncionarios.size();

			return ResponseEntity
					.ok(new VwCasosFuncionariosResponse(buscarVwCasosFuncionarios, code, mensaje, totalResultados));
		} catch (Exception ex) {
			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> validarExiteNoticiaCriminal(String nroUnico, Long consecutivo) {
		List<VwPwaValidaVroUnico> listadoVwPwaValidaVroUnico = new ArrayList<>();
		List<VwPwaValidaVroUnico> buscarVwPwaValidaVroUnico = null;

		List<VwCasosFuncionarios> listadoVwCasosFuncionarios = new ArrayList<>();
		List<VwCasosFuncionarios> buscarVwCasosFuncionarios = null;

		Long code = null;
		String mensaje = "";
		Long totalResultados = null;

		Query q = null;

		try {

			q = em.createNativeQuery("select * from VW_CASOS_FUNCIONARIOS where nro_unico = ? and consecutivo_empleado= ?",
					VwCasosFuncionarios.class);
			
			q.setParameter(1, nroUnico.trim());
			q.setParameter(2, consecutivo);

			listadoVwCasosFuncionarios = q.getResultList();
			System.out.println("listadoVwCasosFuncionarios.size: " + listadoVwCasosFuncionarios.size());

			if (listadoVwCasosFuncionarios.size() == 0) {
				q = em.createNativeQuery("SELECT * FROM VW_PWA_VALIDA_NRO_UNICO where nro_unico = ?", VwPwaValidaVroUnico.class);

				q.setParameter(1, nroUnico.trim());
				
				listadoVwPwaValidaVroUnico = q.getResultList();

				if (listadoVwPwaValidaVroUnico.size() > 0) {
					totalResultados = (long) listadoVwPwaValidaVroUnico.size();
					code = -1L;
					buscarVwPwaValidaVroUnico = listadoVwPwaValidaVroUnico;
					//mensaje = "Se ha encontrado informacion";
					
					mensaje = "No se encontro la noticia criminal.";
				} else {
					totalResultados = (long) listadoVwPwaValidaVroUnico.size();
					code = 0L;
					buscarVwPwaValidaVroUnico = listadoVwPwaValidaVroUnico;
					mensaje = "Puede continuar con la creacion de la noticia criminal.";
				}
			} else {
				totalResultados = (long) listadoVwCasosFuncionarios.size();
				code = -1L;
				mensaje = "La noticia crinal ya existe, ingrese otro numero.";
				buscarVwCasosFuncionarios = listadoVwCasosFuncionarios;
				return ResponseEntity.ok(new VwCasosFuncionariosResponse(buscarVwCasosFuncionarios, code, mensaje,
						totalResultados));

			}
			return ResponseEntity.ok(new VwPwaValidaVroUnicoResponse(buscarVwPwaValidaVroUnico, code, mensaje, totalResultados));
		} catch (Exception ex) {
			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> buscarFuncionarioByIdentificacion(@RequestParam Long identificacion) {
		List<VwPwaAdminUsuarios> listadoVwPwaAdminUsuarios = new ArrayList<>();
		List<VwPwaAdminUsuarios> vwPwaAdminUsuarios = null;
		Long code = null;
		String mensaje = "";

		try {

			Query q = em.createNativeQuery("select * from VW_PWA_ADMIN_USUARIOS where identificacion = ?",
					VwPwaAdminUsuarios.class);
			q.setParameter(1, identificacion);

			listadoVwPwaAdminUsuarios = q.getResultList();

			if (listadoVwPwaAdminUsuarios.size() > 0) {
				code = 0L;
				vwPwaAdminUsuarios = listadoVwPwaAdminUsuarios;
				mensaje = "Se ha encontrado informacion";
			} else {
				code = -1L;
				vwPwaAdminUsuarios = listadoVwPwaAdminUsuarios;
				mensaje = "No se encontro el funcionario.";
			}

			Long totalResultados = (long) listadoVwPwaAdminUsuarios.size();

			return ResponseEntity
					.ok(new VwPwaAdminUsuariosResponse(vwPwaAdminUsuarios, code, mensaje, totalResultados));
		} catch (Exception ex) {
			return ResponseEntity.ok(ex.getMessage());
		}
	}

}