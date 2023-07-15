package co.gov.policia.pwa.modal.service;

import java.io.Serializable;
import java.util.List;

public interface ResponsableNoticiaCriminalListaService extends Serializable{
    
    public List<String> selectResponsableNoticiaCriminalAll();

}
