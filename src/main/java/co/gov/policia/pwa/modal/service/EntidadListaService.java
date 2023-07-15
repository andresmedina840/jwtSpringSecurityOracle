package co.gov.policia.pwa.modal.service;

import java.io.Serializable;
import java.util.List;
import co.gov.policia.pwa.modal.entity.EntidadLista;

public interface EntidadListaService extends Serializable{  

    public List<EntidadLista> selectAllEntidad();

}
