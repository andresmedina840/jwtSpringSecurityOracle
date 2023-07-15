package co.gov.policia.pwa.modal.services.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.modal.entity.CgRefCodesLista;
import co.gov.policia.pwa.modal.service.CgRefCodesListaService;
import co.gov.policia.pwa.modal.service.DepartamentosListaService;
import co.gov.policia.pwa.service.impl.AbstractService;

@Service
public class CgRefCodesListaImpl extends AbstractService implements CgRefCodesListaService{
    
private static final long serialVersionUID = 1L;
    
    @Lazy
    @Autowired
    DepartamentosListaService departamentosListaService;
    
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<CgRefCodesLista> selectAllCgrefcodesLista() {
        List<CgRefCodesLista> listadoCgRefCodesLista = new ArrayList<>();

        try {
            Query q = em.createNativeQuery("select rv_low_value,rv_meaning from usr_sigic.cg_ref_codes where rv_domain = 'TIPO NOTICIA' order by rv_meaning");

            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                CgRefCodesLista cgRefCodesLista = new CgRefCodesLista();
                if (i < lstItems.size()) {
                    cgRefCodesLista.setRvLowValue(obj[0] == null ? null : obj[0].toString());
                    cgRefCodesLista.setRvMeaning(obj[1] == null ? null : obj[1].toString());
                }
                listadoCgRefCodesLista.add(cgRefCodesLista);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista de CgRefCodes. " + ex.getMessage());
        }
        return listadoCgRefCodesLista;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<CgRefCodesLista> selectCgRefCodesListaRol() {
        List<CgRefCodesLista> listadoCgRefCodesLista = new ArrayList<>();

        try {
            Query q = em.createNativeQuery("SELECT rv_low_value,rv_meaning from usr_sigic.cg_ref_codes where rv_domain = 'ROL INVESTIGADOR' ORDER BY rv_meaning");

            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                CgRefCodesLista cgRefCodesLista = new CgRefCodesLista();
                if (i < lstItems.size()) {
                    cgRefCodesLista.setRvLowValue(obj[0] == null ? null : obj[0].toString());
                    cgRefCodesLista.setRvMeaning(obj[1] == null ? null : obj[1].toString());
                }
                listadoCgRefCodesLista.add(cgRefCodesLista);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista de CgRefCodes por Rol. " + ex.getMessage());
        }
        return listadoCgRefCodesLista;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<CgRefCodesLista> selectCgRefCodesListaNovedad() {
        List<CgRefCodesLista> listadoCgRefCodesLista = new ArrayList<>();

        try {
            Query q = em.createNativeQuery("SELECT rv_low_value,rv_meaning from usr_sigic.cg_ref_codes where rv_domain = 'TIPO NOVEDAD' ORDER BY rv_meaning");

            List<Object[]> lstItems = (List<Object[]>) q.getResultList();

            int i = 0;
            for (Object[] obj : lstItems) {
                CgRefCodesLista cgRefCodesLista = new CgRefCodesLista();
                if (i < lstItems.size()) {
                    cgRefCodesLista.setRvLowValue(obj[0] == null ? null : obj[0].toString());
                    cgRefCodesLista.setRvMeaning(obj[1] == null ? null : obj[1].toString());
                }
                listadoCgRefCodesLista.add(cgRefCodesLista);
                i = i + 1;
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista de CgRefCodes por Rol. " + ex.getMessage());
        }
        return listadoCgRefCodesLista;
    }

}
