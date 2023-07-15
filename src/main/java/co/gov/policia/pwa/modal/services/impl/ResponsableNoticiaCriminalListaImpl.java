package co.gov.policia.pwa.modal.services.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.modal.service.ResponsableNoticiaCriminalListaService;
import co.gov.policia.pwa.service.impl.AbstractService;

@Service
public class ResponsableNoticiaCriminalListaImpl extends AbstractService implements ResponsableNoticiaCriminalListaService{

    private static final long serialVersionUID = 1L;

    @Lazy
    @Autowired
    ResponsableNoticiaCriminalListaService responsableNoticiaCriminalListaService;
    
    @SuppressWarnings("unchecked")
	@Override
    @Transactional
    public List<String> selectResponsableNoticiaCriminalAll() {      
        List<String> resultadoConsulta = new ArrayList<>();
        
        List<String> r = new ArrayList<>();
        
        String consultaSql = "select distinct sigl_sigla FROM unidades_dependencia \r\n"
                + "where codigo > 20000  \r\n"
                + "AND sigl_sigla not in ( 'REGI8', 'REGI7', 'REGI6', 'REGI5', 'REGI4', 'REGI3', 'REGI2', 'REGI1', 'OFITE', 'UNIPE', 'UNIPO' )  \r\n"
                + "ORDER BY 1";
        
        System.out.println("consultaSql: " + consultaSql);

        try {
            Query q = em.createNativeQuery(consultaSql);
            
            resultadoConsulta = q.getResultList();

            if (resultadoConsulta.size() > 0) {
                r = resultadoConsulta;
            } else {
                r = new ArrayList<>();
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar lista de responsable de Noticia Criminal. " + ex.getMessage());
        }
        return r;
    }
    
}
