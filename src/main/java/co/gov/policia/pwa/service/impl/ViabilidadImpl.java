package co.gov.policia.pwa.service.impl;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.entity.GraSolicitudHistoricoEstado;
import co.gov.policia.pwa.payload.response.ViabilidadResponse;
import co.gov.policia.pwa.service.ViabilidadService;

@Service
public class ViabilidadImpl extends AbstractService implements ViabilidadService{

	@Override
	@Transactional
	public ResponseEntity<?> insertAdmMaicModuloMenu(GraSolicitudHistoricoEstado graSolicitudHistoricoEstado, String usuarioConexion) {

		StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("PK_PWA_VIABILIDAD.PR_PWA_VIABILIDAD_INS");

		storedProcedureQuery.registerStoredProcedureParameter("I_ID_SOLICITUD", Long.class, ParameterMode.IN);
		//storedProcedureQuery.registerStoredProcedureParameter("I_TIPO_USUARIO", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_DESCRIPCION_ESTADO", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_TRAMITE_ESTADO", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_USUARIO_CREADOR", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_CONS_EMP", Long.class, ParameterMode.IN);

		storedProcedureQuery.registerStoredProcedureParameter("I_CONSECUTIVO", Long.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("I_RESPUESTA", Long.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("I_DESC_RESULTADO", String.class, ParameterMode.OUT);

		storedProcedureQuery.setParameter("I_ID_SOLICITUD", graSolicitudHistoricoEstado.getIdSolicitud());
		System.out.println("I_ID_SOLICITUD: " + graSolicitudHistoricoEstado.getIdSolicitud());
		
		storedProcedureQuery.setParameter("I_DESCRIPCION_ESTADO", graSolicitudHistoricoEstado.getDescripcionEstado().trim().toUpperCase());
		System.out.println("I_DESCRIPCION_ESTADO: " + graSolicitudHistoricoEstado.getDescripcionEstado().trim().toUpperCase());
		
		storedProcedureQuery.setParameter("I_TRAMITE_ESTADO", graSolicitudHistoricoEstado.getTramiteEstado());
		System.out.println("I_TRAMITE_ESTADO: " + graSolicitudHistoricoEstado.getTramiteEstado());

		storedProcedureQuery.setParameter("I_USUARIO_CREADOR", usuarioConexion);
		System.out.println("I_USUARIO_CREADOR: " + usuarioConexion);
		
		storedProcedureQuery.setParameter("I_CONS_EMP", graSolicitudHistoricoEstado.getConsEmp());
		System.out.println("I_CONS_EMP: " + graSolicitudHistoricoEstado.getConsEmp());

		storedProcedureQuery.execute();

		Long response = (Long) storedProcedureQuery.getOutputParameterValue("I_RESPUESTA");
		System.out.println("response: " + response);

		String responseDescription = (String) storedProcedureQuery.getOutputParameterValue("I_DESC_RESULTADO");
		System.out.println("responseDescription: " + responseDescription);

		Long responseConsecutivo = (Long) storedProcedureQuery.getOutputParameterValue("I_CONSECUTIVO");
		System.out.println("responseConsecutivo: " + responseConsecutivo);

		return ResponseEntity.ok(new ViabilidadResponse(null, response, responseDescription, null));
	}


}
