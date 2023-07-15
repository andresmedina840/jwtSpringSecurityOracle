package co.gov.policia.pwa.modal.services.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.modal.entity.EntidadLista;
import co.gov.policia.pwa.modal.service.EntidadListaService;
import co.gov.policia.pwa.service.impl.AbstractService;

@Service
public class EntidadListaImpl extends AbstractService implements EntidadListaService {

    private static final long serialVersionUID = 1L;

    @Lazy
    @Autowired
    EntidadListaService entidadListaService;
    
    @SuppressWarnings("unchecked")
	@Override
    @Transactional
    public List<EntidadLista> selectAllEntidad() {
        List<EntidadLista> listadoEntidadLista = new ArrayList<>();

        try {
            Query q = em.createNativeQuery("SELECT codigo,descripcion from adm_entidades_receptoras where unde_codigo=0 ORDER BY 2");

            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                EntidadLista entidadLista = new EntidadLista();
                if (i < lstItems.size()) {
                    entidadLista.setCodigo(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                    entidadLista.setDescripcion(obj[1] == null ? null : obj[1].toString());
                }
                listadoEntidadLista.add(entidadLista);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista de Entidades. " + ex.getMessage());
        }
        return listadoEntidadLista;
    }

}
