package co.gov.policia.pwa.modal.service;

import java.io.Serializable;
import java.util.List;
import co.gov.policia.pwa.modal.entity.VwLugaresLista;

public interface VwLugaresListaService extends Serializable{  

    public List<VwLugaresLista> selectAllVwLugaresLista();

}
