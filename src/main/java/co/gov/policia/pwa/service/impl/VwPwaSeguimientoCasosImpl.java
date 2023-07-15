package co.gov.policia.pwa.service.impl;

import org.springframework.http.ResponseEntity;
import co.gov.policia.pwa.payload.response.VwPwaSeguimientoCasosResponse;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.entity.VwPwaSeguimientoCasos;
import co.gov.policia.pwa.payload.response.ResponseSp;
import co.gov.policia.pwa.service.VwPwaSeguimientoCasosService;
import org.springframework.stereotype.Service;
import javax.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.ParameterMode;
import javax.persistence.TypedQuery;

@Service
public class VwPwaSeguimientoCasosImpl extends AbstractService implements VwPwaSeguimientoCasosService {

    private static final long serialVersionUID = 1L;

    @Lazy
    @Autowired
    VwPwaSeguimientoCasosService vwPwaSeguimientoCasosService;

    @Override
    @Transactional
    public ResponseEntity<?> insertVwPwaSeguimientoCasos(VwPwaSeguimientoCasos vwPwaSeguimientoCasos, String usuarioConexion) {

        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("PK_PWA_VW_PWA_SEGUIMIENTO_CASO.PR_VWPWASEGUIMIENF_INS");

        storedProcedureQuery.registerStoredProcedureParameter("I_PORCENTAJE_ID", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_NOTICIA_CRIMINAL", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_CONS_CASO", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_FECHA_ASIGNACION", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_ESTADO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("I_USUARIO_CREADOR", String.class, ParameterMode.IN);

        storedProcedureQuery.registerStoredProcedureParameter("I_CONSECUTIVO", Long.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter("I_RESPUESTA", String.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter("I_DESC_RESULTADO", String.class, ParameterMode.OUT);

        storedProcedureQuery.setParameter("I_PORCENTAJE_ID", vwPwaSeguimientoCasos.getPorcentajeId());
        
        storedProcedureQuery.setParameter("I_NOTICIA_CRIMINAL", vwPwaSeguimientoCasos.getNoticiaCriminal().trim());

        storedProcedureQuery.setParameter("I_CONS_CASO", vwPwaSeguimientoCasos.getConsCaso());

        storedProcedureQuery.setParameter("I_FECHA_ASIGNACION", vwPwaSeguimientoCasos.getFechaAsignacion());

        storedProcedureQuery.setParameter("I_ESTADO", vwPwaSeguimientoCasos.getEstado());

        storedProcedureQuery.setParameter("I_USUARIO_CREADOR", usuarioConexion);

        storedProcedureQuery.execute();

        String response = (String) storedProcedureQuery.getOutputParameterValue("I_RESPUESTA");

        String responseDescription = (String) storedProcedureQuery.getOutputParameterValue("I_DESC_RESULTADO");

        long responseConsecutivo = (Long) storedProcedureQuery.getOutputParameterValue("I_CONSECUTIVO");

        return ResponseEntity.ok(new VwPwaSeguimientoCasosResponse(null, response, responseDescription, responseConsecutivo));
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateVwPwaSeguimientoCasos(VwPwaSeguimientoCasos vwPwaSeguimientoCasos, String usuarioConexion) {

        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("PK_PWA_VW_PWA_SEGUIMIENTO_CASO.PR_VWPWASEGUIMIENF_UPD");

        storedProcedureQuery.registerStoredProcedureParameter("U_CONSECUTIVO", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_PORCENTAJE_ID", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_PORCENTAJE", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_AVANCE", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_CONS_CASO", Long.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_FECHA_ASIGNACION", Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_ESTADO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_D_ESTADO", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_USUARIO_MODIFICADOR", String.class, ParameterMode.IN);

        storedProcedureQuery.registerStoredProcedureParameter("U_RAZON_OPERACION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_RAZON_OBSERVACION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("U_RESPUESTA", String.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter("U_DESC_RESULTADO", String.class, ParameterMode.OUT);

        storedProcedureQuery.setParameter("U_CONSECUTIVO", vwPwaSeguimientoCasos.getConsecutivo());

        storedProcedureQuery.setParameter("U_PORCENTAJE_ID", vwPwaSeguimientoCasos.getPorcentajeId());

        storedProcedureQuery.setParameter("U_PORCENTAJE", vwPwaSeguimientoCasos.getPorcentaje());

        storedProcedureQuery.setParameter("U_AVANCE", vwPwaSeguimientoCasos.getAvance());

        storedProcedureQuery.setParameter("U_CONS_CASO", vwPwaSeguimientoCasos.getConsCaso());

        storedProcedureQuery.setParameter("U_FECHA_ASIGNACION", vwPwaSeguimientoCasos.getFechaAsignacion());

        storedProcedureQuery.setParameter("U_ESTADO", vwPwaSeguimientoCasos.getEstado());

        storedProcedureQuery.setParameter("U_D_ESTADO", vwPwaSeguimientoCasos.getDEstado());

        storedProcedureQuery.setParameter("U_USUARIO_MODIFICADOR", usuarioConexion);

        storedProcedureQuery.execute();

        String response = (String) storedProcedureQuery.getOutputParameterValue("U_RESPUESTA");

        String responseDescription = (String) storedProcedureQuery.getOutputParameterValue("U_DESC_RESULTADO");

        return ResponseEntity.ok(new VwPwaSeguimientoCasosResponse(null, response, responseDescription));
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteVwPwaSeguimientoCasos(VwPwaSeguimientoCasos vwPwaSeguimientoCasos, String usuarioConexion) {

        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("PK_PWA_VW_PWA_SEGUIMIENTO_CASO.PR_VWPWASEGUIMIENF_DEL");

        storedProcedureQuery.registerStoredProcedureParameter("D_CONSECUTIVO", Long.class, ParameterMode.IN);

        storedProcedureQuery.registerStoredProcedureParameter("D_RAZON_OPERACION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("D_RAZON_OBSERVACION", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("D_RESPUESTA", String.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter("D_DESC_RESULTADO", String.class, ParameterMode.OUT);

        storedProcedureQuery.setParameter("D_CONSECUTIVO", vwPwaSeguimientoCasos.getConsecutivo());

        storedProcedureQuery.execute();

        String response = (String) storedProcedureQuery.getOutputParameterValue("D_RESPUESTA");

        String responseDescription = (String) storedProcedureQuery.getOutputParameterValue("D_DESC_RESULTADO");

        return ResponseEntity.ok(new ResponseSp(response, responseDescription));
    }

    @Override
    @Transactional
    public ResponseEntity<?> selectVwPwaSeguimientoCasosByConsCaso(Long conscaso) {
        List<VwPwaSeguimientoCasos> listadoVwPwaSeguimienf = new ArrayList<>();
        VwPwaSeguimientoCasos vwPwaSeguimientoCasos = null;
        String code = " ";
        String mensaje = "";
        try {
            TypedQuery<VwPwaSeguimientoCasos> q = em.createQuery(
                    "SELECT u FROM VwPwaSeguimientoCasos u WHERE  u.consCaso=:consCaso", VwPwaSeguimientoCasos.class);
            q.setParameter("consCaso", conscaso);

            listadoVwPwaSeguimienf = q.getResultList();
            if (listadoVwPwaSeguimienf.size() > 0) {
                code = "0";
                vwPwaSeguimientoCasos = listadoVwPwaSeguimienf.get(0);
                mensaje = "Se ha encontrado informacion";
            } else {
                code = "2";
                mensaje = "No se ha encontrado información por conscaso : " + conscaso;
            }
            return ResponseEntity.ok(new VwPwaSeguimientoCasosResponse(vwPwaSeguimientoCasos, code, mensaje));
        } catch (Exception ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> selectVwPwaSeguimientoCasosByConsCasoLike(Long conscaso) {
        List<VwPwaSeguimientoCasos> listadoVwPwaSeguimienf = new ArrayList<>();
        VwPwaSeguimientoCasos vwPwaSeguimientoCasos = null;
        String code = " ";
        String mensaje = "";
        try {
            TypedQuery<VwPwaSeguimientoCasos> q = em.createQuery(
                    "SELECT u FROM VwPwaSeguimientoCasos u WHERE  u.consCaso like :consCaso", VwPwaSeguimientoCasos.class);
            q.setParameter("consCaso", "%" + conscaso + "%");

            listadoVwPwaSeguimienf = q.getResultList();
            if (listadoVwPwaSeguimienf.size() > 0) {
                code = "0";
                vwPwaSeguimientoCasos = listadoVwPwaSeguimienf.get(0);
                mensaje = "Se ha encontrado informacion";
            } else {
                code = "2";
                mensaje = "No se ha encontrado información por conscaso : " + conscaso;
            }
            return ResponseEntity.ok(new VwPwaSeguimientoCasosResponse(vwPwaSeguimientoCasos, code, mensaje));
        } catch (Exception ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public List<VwPwaSeguimientoCasos> selectAllVwPwaSeguimientoCasos() {
        TypedQuery<VwPwaSeguimientoCasos> q = em.createQuery("SELECT u FROM VwPwaSeguimientoCasos u",
                VwPwaSeguimientoCasos.class);
        return q.getResultList();
    }

}