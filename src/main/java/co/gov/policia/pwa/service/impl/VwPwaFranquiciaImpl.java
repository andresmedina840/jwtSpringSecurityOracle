package co.gov.policia.pwa.service.impl;

import org.springframework.http.ResponseEntity;
import co.gov.policia.pwa.payload.response.DiaFranquiciasFuncionalidadesResponse;
import co.gov.policia.pwa.payload.response.VwPwaFranquicivResponse;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.entity.VwPwaFranquicia;
import co.gov.policia.pwa.modal.entity.DiaFranquiciasFuncionalidades;
import co.gov.policia.pwa.service.VwPwaFranquiciaService;
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
public class VwPwaFranquiciaImpl extends AbstractService implements VwPwaFranquiciaService {

	private static final long serialVersionUID = 1L;

	@Lazy
	@Autowired
	VwPwaFranquiciaService vwPwaFranquiciaService;

	@Override
	@Transactional
	public ResponseEntity<?> insertVwPwaFranquicia(VwPwaFranquicia vwPwaFranquicia, String usuarioConexion, Long undeCodigoSipac) {

		StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("PK_PWA_VW_PWA_FRANQUICIA.PR_VW_PWA_FRANQUICIA_INS");

		//storedProcedureQuery.registerStoredProcedureParameter("I_IDENTIFICACION", Long.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_CONS_EMPL", Long.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_FECHA_FIN", Date.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_FECHA_INICIO", Date.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_TOTAL_DIAS", Long.class, ParameterMode.IN);
		//storedProcedureQuery.registerStoredProcedureParameter("I_D_PERMISO", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_PERMISO", Long.class, ParameterMode.IN);
		//storedProcedureQuery.registerStoredProcedureParameter("I_D_TIPO_PERMISO", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_TIPO_PERMISO", String.class, ParameterMode.IN);
		//storedProcedureQuery.registerStoredProcedureParameter("I_FUNCIONARIO", String.class, ParameterMode.IN);
		//storedProcedureQuery.registerStoredProcedureParameter("I_DEPENDENIA", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_USUARIO_CREADOR", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_OBSERVACIONES", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_UNDE_CODIGO", Long.class, ParameterMode.IN);

		storedProcedureQuery.registerStoredProcedureParameter("I_RAZON_OPERACION", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_RAZON_OBSERVACION", String.class, ParameterMode.IN);
		storedProcedureQuery.registerStoredProcedureParameter("I_CONSECUTIVO", Long.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("I_RESPUESTA", String.class, ParameterMode.OUT);
		storedProcedureQuery.registerStoredProcedureParameter("I_DESC_RESULTADO", String.class, ParameterMode.OUT);

		storedProcedureQuery.setParameter("I_CONS_EMPL", vwPwaFranquicia.getConsEmpl());

		storedProcedureQuery.setParameter("I_FECHA_FIN", vwPwaFranquicia.getFechaFin());

		storedProcedureQuery.setParameter("I_FECHA_INICIO", vwPwaFranquicia.getFechaInicio());

		storedProcedureQuery.setParameter("I_TOTAL_DIAS", vwPwaFranquicia.getTotalDias());

		storedProcedureQuery.setParameter("I_PERMISO", vwPwaFranquicia.getPermiso());

		storedProcedureQuery.setParameter("I_TIPO_PERMISO", vwPwaFranquicia.getTipoPermiso());

		storedProcedureQuery.setParameter("I_USUARIO_CREADOR", vwPwaFranquicia.getUsuarioCreador());

		storedProcedureQuery.setParameter("I_OBSERVACIONES", vwPwaFranquicia.getObservaciones());

		storedProcedureQuery.setParameter("I_UNDE_CODIGO", undeCodigoSipac);

		storedProcedureQuery.execute();

		String response = (String) storedProcedureQuery.getOutputParameterValue("I_RESPUESTA");

		String responseDescription = (String) storedProcedureQuery.getOutputParameterValue("I_DESC_RESULTADO");

		long responseConsecutivo = (Long) storedProcedureQuery.getOutputParameterValue("I_CONSECUTIVO");

		return ResponseEntity.ok(new VwPwaFranquicivResponse(null, response, responseDescription, responseConsecutivo));
	}
	
	@SuppressWarnings("unchecked")
    @Override
    @Transactional
    public ResponseEntity<?> tipoPermisoFranquiciaOtorgada() {
        List<DiaFranquiciasFuncionalidades> listadoDiaFranquiciasFuncionalidades = new ArrayList<>();
        List<DiaFranquiciasFuncionalidades> diaFranquiciasFuncionalidades = null;
        Long code = null;
        String mensaje = "";
        try {

            Query q = em.createNativeQuery(
                    "select * from DIA_FRANQUICIAS_FUNCIONALIDADES where tipo_variable = 'TIPOPERMISO' and estado = 'AC' order by descripcion", DiaFranquiciasFuncionalidades.class);

            listadoDiaFranquiciasFuncionalidades = q.getResultList();
            if (listadoDiaFranquiciasFuncionalidades.size() > 0) {
                code = 0L;
                diaFranquiciasFuncionalidades = listadoDiaFranquiciasFuncionalidades;
                mensaje = "Se ha encontrado informacion";
            } else {
                code = 2L;
                mensaje = "No se ha encontrado información.";
                diaFranquiciasFuncionalidades = new ArrayList<DiaFranquiciasFuncionalidades>();
            }
            Long totalResultados = (long) listadoDiaFranquiciasFuncionalidades.size();
            return ResponseEntity.ok(new DiaFranquiciasFuncionalidadesResponse(diaFranquiciasFuncionalidades, code, mensaje, totalResultados));
        } catch (Exception ex) {

            return ResponseEntity.ok(ex.getMessage());
        }
    }
	
	@SuppressWarnings({ "unchecked"})
    @Override
    @Transactional
    public ResponseEntity<?> tipoPermisoOFranquicia(String codigoFranquicia) {
        List<DiaFranquiciasFuncionalidades> listadoDiaFranquiciasFuncionalidades = new ArrayList<>();
        List<DiaFranquiciasFuncionalidades> diaFranquiciasFuncionalidades = null;
        Long code = null;
        String mensaje = "";
        Query q = null;
        try {
            
            if (codigoFranquicia.equals("1")) {
                q = em.createNativeQuery(
                        "select * from DIA_FRANQUICIAS_FUNCIONALIDADES where tipo_variable = 'PERMISO_FRANQUICIA' and estado = 'AC' order by descripcion", DiaFranquiciasFuncionalidades.class);
            }

            if (codigoFranquicia.equals("3")) {
                q = em.createNativeQuery(
                        "select * from DIA_FRANQUICIAS_FUNCIONALIDADES where tipo_variable = 'PERMISO' and estado = 'AC' order by descripcion", DiaFranquiciasFuncionalidades.class);
            }
            
            listadoDiaFranquiciasFuncionalidades = q.getResultList();
            
            if (listadoDiaFranquiciasFuncionalidades.size() > 0) {
                code = 0L;
                diaFranquiciasFuncionalidades = listadoDiaFranquiciasFuncionalidades;
                mensaje = "Se ha encontrado informacion";
            } else {
                code = 2L;
                mensaje = "No se ha encontrado información.";
                diaFranquiciasFuncionalidades = new ArrayList<DiaFranquiciasFuncionalidades>();
            }
            Long totalResultados = (long) listadoDiaFranquiciasFuncionalidades.size();
            return ResponseEntity.ok(new DiaFranquiciasFuncionalidadesResponse(diaFranquiciasFuncionalidades, code, mensaje, totalResultados));
        } catch (Exception ex) {

            return ResponseEntity.ok(ex.getMessage());
        }
    }
	
	@SuppressWarnings("unchecked")
    @Override
    @Transactional
    public ResponseEntity<?> totalDiasPermisosFranquicias() {
        List<DiaFranquiciasFuncionalidades> listadoDiaFranquiciasFuncionalidades = new ArrayList<>();
        List<DiaFranquiciasFuncionalidades> diaFranquiciasFuncionalidades = null;
        Long code = null;
        String mensaje = "";
        try {

            Query q = em.createNativeQuery(
                    "select * from DIA_FRANQUICIAS_FUNCIONALIDADES where tipo_variable = 'DIACOMPESATORIO' and estado = 'AC' order by descripcion", DiaFranquiciasFuncionalidades.class);

            listadoDiaFranquiciasFuncionalidades = q.getResultList();
            if (listadoDiaFranquiciasFuncionalidades.size() > 0) {
                code = 0L;
                diaFranquiciasFuncionalidades = listadoDiaFranquiciasFuncionalidades;
                mensaje = "Se ha encontrado informacion";
            } else {
                code = 2L;
                mensaje = "No se ha encontrado información.";
                diaFranquiciasFuncionalidades = new ArrayList<DiaFranquiciasFuncionalidades>();
            }
            Long totalResultados = (long) listadoDiaFranquiciasFuncionalidades.size();
            return ResponseEntity.ok(new DiaFranquiciasFuncionalidadesResponse(diaFranquiciasFuncionalidades, code, mensaje, totalResultados));
        } catch (Exception ex) {

            return ResponseEntity.ok(ex.getMessage());
        }
    }

}