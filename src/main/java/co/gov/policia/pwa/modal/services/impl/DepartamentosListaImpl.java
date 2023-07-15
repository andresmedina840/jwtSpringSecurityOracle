package co.gov.policia.pwa.modal.services.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.modal.entity.DepartamentosLista;
import co.gov.policia.pwa.modal.entity.MunicipiosLista;
import co.gov.policia.pwa.modal.service.DepartamentosListaService;
import co.gov.policia.pwa.service.impl.AbstractService;

@Service
public class DepartamentosListaImpl extends AbstractService implements DepartamentosListaService {

    private static final long serialVersionUID = 1L;
    
    @Lazy
    @Autowired
    DepartamentosListaService departamentosListaService;
    
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<DepartamentosLista> selectAllDepartamentos() {
        List<DepartamentosLista> listadoDepartamentosLista = new ArrayList<>();

        try {
            Query q = em.createNativeQuery("SELECT departamento_id,departamento from vw_departamentos ORDER BY 2");

            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                DepartamentosLista departamentosLista = new DepartamentosLista();
                if (i < lstItems.size()) {
                    departamentosLista.setDepartamentoId(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                    departamentosLista.setDepartamento(obj[1] == null ? null : obj[1].toString());
                }
                listadoDepartamentosLista.add(departamentosLista);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista de Departamentos. " + ex.getMessage());
        }
        return listadoDepartamentosLista;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<MunicipiosLista> selectMunicipiosByDepartamentoId(Long departamentoId) {
        List<MunicipiosLista> listadoMunicipiosLista = new ArrayList<>();

        try {
            Query q = em.createNativeQuery("SELECT LG.CODIGO,UPPER(LG.DESCRIPCION) MUNICIPIO\r\n"
                    + "FROM ADM_LUGARES_GEOGRAFICOS LG\r\n"
                    + "WHERE LG.LUGE_CODIGO=?\r\n"
                    + "AND LG.TIPO='CM' ORDER BY 2");
            
            q.setParameter(1, departamentoId);

            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                MunicipiosLista municipiosLista = new MunicipiosLista();
                if (i < lstItems.size()) {
                    municipiosLista.setCodigo(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
                    municipiosLista.setMunicipio(obj[1] == null ? null : obj[1].toString());
                }
                listadoMunicipiosLista.add(municipiosLista);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista de Departamentos. " + ex.getMessage());
        }
        return listadoMunicipiosLista;
    }
    
}
