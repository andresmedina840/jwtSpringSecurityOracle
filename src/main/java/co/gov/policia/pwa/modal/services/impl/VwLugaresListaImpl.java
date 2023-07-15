package co.gov.policia.pwa.modal.services.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.modal.entity.VwLugaresLista;
import co.gov.policia.pwa.modal.service.VwLugaresListaService;
import co.gov.policia.pwa.service.impl.AbstractService;

@Service
public class VwLugaresListaImpl extends AbstractService implements VwLugaresListaService{
    
    private static final long serialVersionUID = 1L;

    @Lazy
    @Autowired
    VwLugaresListaService vwLugaresListaService;
    
    @SuppressWarnings("unchecked")
	@Override
    @Transactional
    public List<VwLugaresLista> selectAllVwLugaresLista() {
        List<VwLugaresLista> listadoVwLugaresLista = new ArrayList<>();

        try {
            Query q = em.createNativeQuery("SELECT lugar_id, lugar||' - '||departamento ciudad_departamento from VW_LUGARES VL order by 2");

            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                VwLugaresLista vwLugaresLista = new VwLugaresLista();
                if (i < lstItems.size()) {
                    vwLugaresLista.setLugarId(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                    vwLugaresLista.setCiudadDepartamento(obj[1] == null ? null : obj[1].toString());
                }
                listadoVwLugaresLista.add(vwLugaresLista);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista de Adm Lista Conductas. " + ex.getMessage());
        }
        return listadoVwLugaresLista;
    }

}
