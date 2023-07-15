package co.gov.policia.pwa.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.entity.VwPwaCriteriosTramiteGraco;
import co.gov.policia.pwa.payload.response.VwPwaCriteriosTramiteGracoResponse;
import co.gov.policia.pwa.service.VwPwaCriteriosTramiteGracoService;

@Service
public class VwPwaCriteriosTramiteGracoImpl extends AbstractService implements VwPwaCriteriosTramiteGracoService{
	
	@Lazy
	@Autowired
    VwPwaCriteriosTramiteGracoService vwPwaCriteriosTramiteGracoService;
	
	@SuppressWarnings("unchecked")
	@Override
    @Transactional
    public ResponseEntity<?> verTabCriterios(Long consecutivo) {
        List<VwPwaCriteriosTramiteGraco> listadoVwPwaCriteriosTramiteGraco = new ArrayList<>();

        Long code = 0L;
        String mensaje = "";
        try {
        	Query q = em.createNativeQuery("SELECT * FROM VW_PWA_CRITERIOS_TRAMITE_GRACO WHERE ID_SOLICITUD = ?", VwPwaCriteriosTramiteGraco.class);
            
            q.setParameter(1, consecutivo);

            listadoVwPwaCriteriosTramiteGraco = q.getResultList();
            
            if (listadoVwPwaCriteriosTramiteGraco.size() > 0) {
                code = 0L;
                mensaje = "Se ha encontrado informacion";
            } else {
                code = 2L;
                mensaje = "No se ha encontrado información.";
                listadoVwPwaCriteriosTramiteGraco = new ArrayList<>();
            }
            Long totalResultados = (long) listadoVwPwaCriteriosTramiteGraco.size();
            return ResponseEntity.ok(new VwPwaCriteriosTramiteGracoResponse(listadoVwPwaCriteriosTramiteGraco, code, mensaje, totalResultados));
        } catch (Exception ex) {

            return ResponseEntity.ok(ex.getMessage());
        }
    }

}
