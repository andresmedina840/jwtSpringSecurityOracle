package co.gov.policia.pwa.modal.services.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.modal.entity.AdmListaConductasLista;
import co.gov.policia.pwa.modal.service.AdmListaConductasListaService;
import co.gov.policia.pwa.service.impl.AbstractService;

@Service
public class AdmListaConductasListaImpl extends AbstractService implements AdmListaConductasListaService{
    
    private static final long serialVersionUID = 1L;

    @Lazy
    @Autowired
    AdmListaConductasListaService admListaConductasListaService;
    
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<AdmListaConductasLista> selectAllAdmListaConductasLista() {
        List<AdmListaConductasLista> listadoAdmListaConductasLista = new ArrayList<>();

        try {
            Query q = em.createNativeQuery("select consecutivo, descripcion FROM adm_lista_conductas where tipo= 'DE' and vigencia = 2000 order by 2");

            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                AdmListaConductasLista admListaConductasLista = new AdmListaConductasLista();
                if (i < lstItems.size()) {
                    admListaConductasLista.setConsecutivo(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                    admListaConductasLista.setDescripcion(obj[1] == null ? null : obj[1].toString());
                }
                listadoAdmListaConductasLista.add(admListaConductasLista);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista de Adm Lista Conductas. " + ex.getMessage());
        }
        return listadoAdmListaConductasLista;
    }

}
