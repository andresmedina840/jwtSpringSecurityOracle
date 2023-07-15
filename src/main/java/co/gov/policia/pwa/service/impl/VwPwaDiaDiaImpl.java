package co.gov.policia.pwa.service.impl;

import org.springframework.http.ResponseEntity;
import co.gov.policia.pwa.payload.response.VwPwaDiaDialResponse;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.entity.VwPwaDiaDia;
import co.gov.policia.pwa.service.VwPwaDiaDiaService;
import org.springframework.stereotype.Service;
import javax.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import java.util.Date;
import javax.persistence.ParameterMode;

@Service
public class VwPwaDiaDiaImpl extends AbstractService implements VwPwaDiaDiaService {

	private static final long serialVersionUID = 1L;

	@Lazy
	@Autowired
	VwPwaDiaDiaService vwPwaDiaDiaService;

	@Override
	@Transactional
	public ResponseEntity<?> insertVwPwaDiaDia(VwPwaDiaDia vwPwaDiaDia, String usuarioConexion) {

		StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("PK_PWA_VW_PWA_DIA_DIA.PR_VW_PWA_DIA_DIA_INS");

		storedProcedureQuery.registerStoredProcedureParameter("I_CONS_EMPL", Long.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_ACTIVIDAD", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_FECHA", Date.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_USUARIO_CREADOR", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_AMBITO", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_TIPO_EVIDENCIA", String.class, ParameterMode.IN);
		
		storedProcedureQuery.registerStoredProcedureParameter("I_CONSECUTIVO", Long.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("I_RESPUESTA", String.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("I_DESC_RESULTADO", String.class, ParameterMode.OUT);

	    storedProcedureQuery.setParameter("I_CONS_EMPL", vwPwaDiaDia.getConsEmpl());
	    
	    storedProcedureQuery.setParameter("I_ACTIVIDAD", vwPwaDiaDia.getActividad());
           
		storedProcedureQuery.setParameter("I_FECHA", new Date());

		storedProcedureQuery.setParameter("I_USUARIO_CREADOR", vwPwaDiaDia.getUsuarioCreador());

		storedProcedureQuery.setParameter("I_AMBITO", vwPwaDiaDia.getAmbito());

		storedProcedureQuery.setParameter("I_TIPO_EVIDENCIA", vwPwaDiaDia.getTipoEvidencia());

		storedProcedureQuery.execute();

		String response = (String) storedProcedureQuery.getOutputParameterValue("I_RESPUESTA");

		String responseDescription = (String) storedProcedureQuery.getOutputParameterValue("I_DESC_RESULTADO");

		long responseConsecutivo = (Long) storedProcedureQuery.getOutputParameterValue("I_CONSECUTIVO");

		return ResponseEntity.ok(new VwPwaDiaDialResponse(null, response, responseDescription, responseConsecutivo));
	}

}