package co.gov.policia.pwa.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.entity.VwPwaSolicitudesTramiteGraco;
import co.gov.policia.pwa.payload.response.TotalViabiliadResponse;
import co.gov.policia.pwa.payload.response.VwPwaSolicitudesTramiteGracoResponse;
import co.gov.policia.pwa.service.VwPwaSolicitudesTramiteGracoService;

@Service
public class VwPwaSolicitudesTramiteGracoImpl extends AbstractService implements VwPwaSolicitudesTramiteGracoService{

	@Lazy
    @Autowired
    VwPwaSolicitudesTramiteGracoService vwPwaSolicitudesTramiteGracoService;
	
	@Override
    @Transactional
    public ResponseEntity<?> countVwPwaSolicitudesTramiteGraco(Long salaCodigo, Long consEmpSala) {
        
        Long r = null;
        
        Long code = null;
        String mensaje = "";
        try {
            Query q = em.createNativeQuery("select count(*) from VW_PWA_SOLICITUDES_TRAMITE_GRACO where sala_codigo = ? and cons_emp_sala = ?");
            
            q.setParameter(1, salaCodigo);
            q.setParameter(2, consEmpSala);
            
            BigDecimal conteoTotalBigDecimal = (BigDecimal) q.getSingleResult();
            String conteoTotalString = conteoTotalBigDecimal.toString();  		
			long conteoTotalLong = Long.parseLong(conteoTotalString);  
            
            if (conteoTotalLong >= 0) {            	
                code = 0L;
                r = conteoTotalLong;
                mensaje = "Se ha encontrado informacion";
            } else {
                code = 2L;
                mensaje = "No se ha encontrado información.";
            }
            return ResponseEntity.ok(new TotalViabiliadResponse(r, code, mensaje));
        } catch (Exception ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }
	
	@SuppressWarnings("unchecked")
	@Override
    @Transactional
    public ResponseEntity<?> datosTablaSolicitudesTramiteGraco(Long salaCodigo, Long consEmpSala) {
        List<VwPwaSolicitudesTramiteGraco> listadoVwPwaSolicitudesTramiteGraco = new ArrayList<>();

        Long code = null;
        String mensaje = "";
        try {
        	Query q = em.createNativeQuery("select * from VW_PWA_SOLICITUDES_TRAMITE_GRACO where sala_codigo = ? and cons_emp_sala = ?", VwPwaSolicitudesTramiteGraco.class);
            
            q.setParameter(1, salaCodigo);
            q.setParameter(2, consEmpSala);

            listadoVwPwaSolicitudesTramiteGraco = q.getResultList();
            
            if (listadoVwPwaSolicitudesTramiteGraco.size() > 0) {
                code = 0L;
                mensaje = "Se ha encontrado informacion";
            } else {
                code = 2L;
                mensaje = "No se ha encontrado información.";
                listadoVwPwaSolicitudesTramiteGraco = new ArrayList<>();
            }
            Long totalResultados = (long) listadoVwPwaSolicitudesTramiteGraco.size();
            return ResponseEntity.ok(new VwPwaSolicitudesTramiteGracoResponse(listadoVwPwaSolicitudesTramiteGraco, code, mensaje, totalResultados));
        } catch (Exception ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }
	
	@SuppressWarnings("unchecked")
	@Override
    @Transactional
    public ResponseEntity<?> verDatosTablaSolicitudesTramiteGraco(Long consecutivo) {
        List<VwPwaSolicitudesTramiteGraco> listadoVwPwaSolicitudesTramiteGraco = new ArrayList<>();

        Long code = 0L;
        String mensaje = "";
        try {
        	Query q = em.createNativeQuery("select * from VW_PWA_SOLICITUDES_TRAMITE_GRACO where CONSECUTIVO = ?", VwPwaSolicitudesTramiteGraco.class);
            
            q.setParameter(1, consecutivo);

            listadoVwPwaSolicitudesTramiteGraco = q.getResultList();
            
            if (listadoVwPwaSolicitudesTramiteGraco.size() > 0) {
                code = 0L;
                mensaje = "Se ha encontrado informacion";
            } else {
                code = 2L;
                mensaje = "No se ha encontrado información.";
                listadoVwPwaSolicitudesTramiteGraco = new ArrayList<>();
            }
            Long totalResultados = (long) listadoVwPwaSolicitudesTramiteGraco.size();
            return ResponseEntity.ok(new VwPwaSolicitudesTramiteGracoResponse(listadoVwPwaSolicitudesTramiteGraco, code, mensaje, totalResultados));
        } catch (Exception ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }
	
}
