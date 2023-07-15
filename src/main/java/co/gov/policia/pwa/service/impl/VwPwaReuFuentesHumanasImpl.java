package co.gov.policia.pwa.service.impl;

import org.springframework.http.ResponseEntity;
import co.gov.policia.pwa.payload.response.VwPwaReuFuentesHumanasResponse;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.entity.VwPwaReuFuentesHumanas;
import co.gov.policia.pwa.service.VwPwaReuFuentesHumanasService;
import org.springframework.stereotype.Service;
import javax.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import java.util.Date;
import javax.persistence.ParameterMode;

@Service
public class VwPwaReuFuentesHumanasImpl extends AbstractService implements VwPwaReuFuentesHumanasService {

    private static final long serialVersionUID = 1L;

    @Lazy
    @Autowired
    VwPwaReuFuentesHumanasService vwPwaReuFuentesHumanasService;

    @Override
    @Transactional
    public ResponseEntity<?> insertVwPwaReuFuentex(VwPwaReuFuentesHumanas vwPwaReuFuentesHumanas, String usuarioConexion) {

        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("USR_SIGIC.PK_PWA_REU_FUENTES_HUMANAS.PR_VWPWAREUFUENTEX_INS");

        storedProcedureQuery.registerStoredProcedureParameter("I_FUENTE_ID", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_FECHA_REUNION", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_HORA_REUNION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CONS_EMP", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_PAIS_ID", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_DEPARTAMENTO_ID", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_MUNICIPIO_ID", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_LOCALIDAD", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_BARRIO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_DIRECCION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CORREGIMIENTO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_VEREDA", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_ZONA", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_DESCRIPCION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_USUARIO_CREADOR", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_PROCESO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CONS_CASO", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CONS_EMP_APOYO", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_UNDE_CODIGO", Long.class, ParameterMode.IN); 

        storedProcedureQuery.registerStoredProcedureParameter("I_CONSECUTIVO", Long.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter("I_RESPUESTA", String.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter("I_DESC_RESULTADO", String.class, ParameterMode.OUT);

        storedProcedureQuery.setParameter("I_FUENTE_ID", vwPwaReuFuentesHumanas.getFuenteId());

        storedProcedureQuery.setParameter("I_FECHA_REUNION", vwPwaReuFuentesHumanas.getFechaReunion());

        storedProcedureQuery.setParameter("I_HORA_REUNION", vwPwaReuFuentesHumanas.getHoraReunion());

        storedProcedureQuery.setParameter("I_CONS_EMP", vwPwaReuFuentesHumanas.getConsEmp());

        storedProcedureQuery.setParameter("I_PAIS_ID", vwPwaReuFuentesHumanas.getPaisId());

        storedProcedureQuery.setParameter("I_DEPARTAMENTO_ID", vwPwaReuFuentesHumanas.getDepartamentoId());

        storedProcedureQuery.setParameter("I_MUNICIPIO_ID", vwPwaReuFuentesHumanas.getMunicipioId());

        storedProcedureQuery.setParameter("I_LOCALIDAD", vwPwaReuFuentesHumanas.getLocalidad().trim().toUpperCase());

        storedProcedureQuery.setParameter("I_BARRIO", vwPwaReuFuentesHumanas.getBarrio().trim().toUpperCase());

        storedProcedureQuery.setParameter("I_DIRECCION", vwPwaReuFuentesHumanas.getDireccion().trim().toUpperCase());

        storedProcedureQuery.setParameter("I_CORREGIMIENTO", vwPwaReuFuentesHumanas.getCorregimiento().trim().toUpperCase());

        storedProcedureQuery.setParameter("I_VEREDA", vwPwaReuFuentesHumanas.getVereda().trim().toUpperCase());

        storedProcedureQuery.setParameter("I_ZONA", vwPwaReuFuentesHumanas.getZona());

        storedProcedureQuery.setParameter("I_DESCRIPCION", vwPwaReuFuentesHumanas.getDescripcion());

        storedProcedureQuery.setParameter("I_USUARIO_CREADOR", usuarioConexion);

        storedProcedureQuery.setParameter("I_PROCESO", vwPwaReuFuentesHumanas.getProceso());

        storedProcedureQuery.setParameter("I_CONS_CASO", vwPwaReuFuentesHumanas.getConsCaso());

        storedProcedureQuery.setParameter("I_CONS_EMP_APOYO", vwPwaReuFuentesHumanas.getConsEmpApoyo());

        storedProcedureQuery.setParameter("I_UNDE_CODIGO", vwPwaReuFuentesHumanas.getUndeCodigo());

        storedProcedureQuery.execute();

        String response = (String) storedProcedureQuery.getOutputParameterValue("I_RESPUESTA");

        String responseDescription = (String) storedProcedureQuery.getOutputParameterValue("I_DESC_RESULTADO");

        long responseConsecutivo = (Long) storedProcedureQuery.getOutputParameterValue("I_CONSECUTIVO");

        return ResponseEntity.ok(new VwPwaReuFuentesHumanasResponse(null, response, responseDescription, responseConsecutivo));
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateVwPwaReuFuentex(VwPwaReuFuentesHumanas vwPwaReuFuentesHumanas, String usuarioConexion) {

        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("USR_SIGIC.PK_PWA_REU_FUENTES_HUMANAS.PR_VWPWAREUFUENTEX_UPD");

        storedProcedureQuery.registerStoredProcedureParameter("U_CONSECUTIVO", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_FUENTE_ID", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_FECHA_REUNION", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_HORA_REUNION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_CONS_EMP", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_PAIS_ID", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_DEPARTAMENTO_ID", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_MUNICIPIO_ID", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_LOCALIDAD", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_BARRIO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_DIRECCION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_CORREGIMIENTO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_VEREDA", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_ZONA", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_DESCRIPCION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_USUARIO_MODIFICADOR", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_CONS_CASO", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_CONS_EMP_APOYO", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_UNDE_CODIGO", Long.class, ParameterMode.IN);

        storedProcedureQuery.registerStoredProcedureParameter("U_RESPUESTA", String.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter("U_DESC_RESULTADO", String.class, ParameterMode.OUT);

        storedProcedureQuery.setParameter("U_CONSECUTIVO", vwPwaReuFuentesHumanas.getConsecutivo());

        storedProcedureQuery.setParameter("U_FUENTE_ID", vwPwaReuFuentesHumanas.getFuenteId());

        storedProcedureQuery.setParameter("U_FECHA_REUNION", vwPwaReuFuentesHumanas.getFechaReunion());

        storedProcedureQuery.setParameter("U_HORA_REUNION", vwPwaReuFuentesHumanas.getHoraReunion());

        storedProcedureQuery.setParameter("U_CONS_EMP", vwPwaReuFuentesHumanas.getConsEmp());

        storedProcedureQuery.setParameter("U_PAIS_ID", vwPwaReuFuentesHumanas.getPaisId());

        storedProcedureQuery.setParameter("U_DEPARTAMENTO_ID", vwPwaReuFuentesHumanas.getDepartamentoId());

        storedProcedureQuery.setParameter("U_MUNICIPIO_ID", vwPwaReuFuentesHumanas.getMunicipioId());

        storedProcedureQuery.setParameter("U_LOCALIDAD", vwPwaReuFuentesHumanas.getLocalidad());

        storedProcedureQuery.setParameter("U_BARRIO", vwPwaReuFuentesHumanas.getBarrio());

        storedProcedureQuery.setParameter("U_DIRECCION", vwPwaReuFuentesHumanas.getDireccion());

        storedProcedureQuery.setParameter("U_CORREGIMIENTO", vwPwaReuFuentesHumanas.getCorregimiento());

        storedProcedureQuery.setParameter("U_VEREDA", vwPwaReuFuentesHumanas.getVereda());

        storedProcedureQuery.setParameter("U_ZONA", vwPwaReuFuentesHumanas.getZona());

        storedProcedureQuery.setParameter("U_DESCRIPCION", vwPwaReuFuentesHumanas.getDescripcion());

        storedProcedureQuery.setParameter("U_USUARIO_MODIFICADOR", vwPwaReuFuentesHumanas.getUsuarioModificador());

        storedProcedureQuery.setParameter("U_CONS_CASO", vwPwaReuFuentesHumanas.getConsCaso());

        storedProcedureQuery.setParameter("U_CONS_EMP_APOYO", vwPwaReuFuentesHumanas.getConsEmpApoyo());

        storedProcedureQuery.setParameter("U_UNDE_CODIGO", vwPwaReuFuentesHumanas.getUndeCodigo());

        storedProcedureQuery.execute();

        String response = (String) storedProcedureQuery.getOutputParameterValue("U_RESPUESTA");

        String responseDescription = (String) storedProcedureQuery.getOutputParameterValue("U_DESC_RESULTADO");

        return ResponseEntity.ok(new VwPwaReuFuentesHumanasResponse(null, response, responseDescription));
    }

}