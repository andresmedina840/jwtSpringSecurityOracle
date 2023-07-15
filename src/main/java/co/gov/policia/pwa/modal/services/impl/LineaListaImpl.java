package co.gov.policia.pwa.modal.services.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.modal.entity.LineaLista;
import co.gov.policia.pwa.modal.service.LineaListaService;
import co.gov.policia.pwa.service.impl.AbstractService;

@Service
public class LineaListaImpl extends AbstractService implements LineaListaService{
    
    private static final long serialVersionUID = 1L;

    @Lazy
    @Autowired
    LineaListaService lineaListaService;
    
    @SuppressWarnings("unchecked")
	@Override
    @Transactional
    public List<LineaLista> selectAllLinea() {
        List<LineaLista> listadoLineaLista = new ArrayList<>();

        try {
            Query q = em.createNativeQuery("select adm_lineas_id,descripcion FROM adm_lineas_inv ORDER BY 2");

            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                LineaLista lineaLista = new LineaLista();
                if (i < lstItems.size()) {
                    lineaLista.setAdmLineasId(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                    lineaLista.setDescripcion(obj[1] == null ? null : obj[1].toString());
                }
                listadoLineaLista.add(lineaLista);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista de Entidades. " + ex.getMessage());
        }
        return listadoLineaLista;
    }

}
