package co.gov.policia.pwa.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.entity.VwPwaTrazabilidadTramiteGraco;
import co.gov.policia.pwa.payload.response.VwPwaTrazabilidadTramiteGracoResponse;
import co.gov.policia.pwa.service.VwPwaTrazabilidadTramiteGracoService;

@Service
public class VwPwaTrazabilidadTramiteGracoImpl extends AbstractService implements VwPwaTrazabilidadTramiteGracoService{
	
	@Lazy
    @Autowired
    VwPwaTrazabilidadTramiteGracoService vwPwaTrazabilidadTramiteGracoService;	
	
	@SuppressWarnings("unchecked")
	@Override
    @Transactional
    public ResponseEntity<?> consultaTrazabilidadTramiteGraco(Long consecutivo) {
        List<VwPwaTrazabilidadTramiteGraco> listadoVwPwaTrazabilidadTramiteGraco = new ArrayList<>();

        Long code = 0L;
        String mensaje = "";
        try {
        	Query q = em.createNativeQuery("SELECT * FROM VW_PWA_TRAZABILIDAD_TRAMITE_GRACO WHERE ID_SOLICITUD = ?", VwPwaTrazabilidadTramiteGraco.class);
            
            q.setParameter(1, consecutivo);

            listadoVwPwaTrazabilidadTramiteGraco = q.getResultList();
            
            if (listadoVwPwaTrazabilidadTramiteGraco.size() > 0) {
                code = 0L;
                mensaje = "Se ha encontrado informacion";
            } else {
                code = 2L;
                mensaje = "No se ha encontrado información.";
                listadoVwPwaTrazabilidadTramiteGraco = new ArrayList<>();
            }
            Long totalResultados = (long) listadoVwPwaTrazabilidadTramiteGraco.size();
            return ResponseEntity.ok(new VwPwaTrazabilidadTramiteGracoResponse(listadoVwPwaTrazabilidadTramiteGraco, code, mensaje, totalResultados));
        } catch (Exception ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }

}
