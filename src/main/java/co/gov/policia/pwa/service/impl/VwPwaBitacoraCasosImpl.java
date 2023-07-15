package co.gov.policia.pwa.service.impl;

import org.springframework.http.ResponseEntity;
import co.gov.policia.pwa.payload.response.VwPwaBitacoraCasosResponse;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.entity.VwPwaBitacoraCasos;
import co.gov.policia.pwa.service.VwPwaBitacoraCasosService;
import org.springframework.stereotype.Service;
import javax.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import javax.persistence.ParameterMode;

@Service
public class VwPwaBitacoraCasosImpl extends AbstractService implements VwPwaBitacoraCasosService {

    private static final long serialVersionUID = 1L;

    @Lazy
    @Autowired
    VwPwaBitacoraCasosService vwPwaBitacoraCasosService;

    @Override
    @Transactional
    public ResponseEntity<?> insertVwPwaBitacoraCasos(VwPwaBitacoraCasos vwPwaBitacoraCasos, String usuarioConexion) {

        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("PK_PWA_VW_PWA_BITACORA_CASOS.PR_VWPWABITACORACT_INS");

        storedProcedureQuery.registerStoredProcedureParameter("I_UNDE_CODIGO", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_ACTIVIDAD", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CONS_CASO", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_USUARIO_CREADOR", String.class, ParameterMode.IN);

        storedProcedureQuery.registerStoredProcedureParameter("I_RAZON_OPERACION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_RAZON_OBSERVACION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CONSECUTIVO", Long.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter("I_RESPUESTA", String.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter("I_DESC_RESULTADO", String.class, ParameterMode.OUT);

        storedProcedureQuery.setParameter("I_UNDE_CODIGO", vwPwaBitacoraCasos.getUndeCodigo());
        System.out.println("I_UNDE_CODIGO: " + vwPwaBitacoraCasos.getUndeCodigo());

        storedProcedureQuery.setParameter("I_ACTIVIDAD", vwPwaBitacoraCasos.getActividad());
        System.out.println("I_ACTIVIDAD: " + vwPwaBitacoraCasos.getActividad());

        storedProcedureQuery.setParameter("I_CONS_CASO", vwPwaBitacoraCasos.getConsCaso());
        System.out.println("I_CONS_CASO: " + vwPwaBitacoraCasos.getConsCaso());

        storedProcedureQuery.setParameter("I_USUARIO_CREADOR", vwPwaBitacoraCasos.getUsuarioCreador());
        System.out.println("I_USUARIO_CREADOR: " + vwPwaBitacoraCasos.getUsuarioCreador());

        storedProcedureQuery.execute();

        String response = (String) storedProcedureQuery.getOutputParameterValue("I_RESPUESTA");
        System.out.println("response: " + response);

        String responseDescription = (String) storedProcedureQuery.getOutputParameterValue("I_DESC_RESULTADO");
        System.out.println("responseDescription: " + responseDescription);

        long responseConsecutivo = (Long) storedProcedureQuery.getOutputParameterValue("I_CONSECUTIVO");
        System.out.println("responseConsecutivo: " + responseConsecutivo);

        return ResponseEntity.ok(new VwPwaBitacoraCasosResponse(null, response, responseDescription, responseConsecutivo));
    }

}