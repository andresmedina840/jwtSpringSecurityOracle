package co.gov.policia.pwa.modal.service;

import java.io.Serializable;
import java.util.List;
import co.gov.policia.pwa.modal.entity.LineaLista;

public interface LineaListaService extends Serializable{  

    public List<LineaLista> selectAllLinea();

}
