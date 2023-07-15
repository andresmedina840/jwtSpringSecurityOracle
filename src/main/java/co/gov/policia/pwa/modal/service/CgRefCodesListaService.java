package co.gov.policia.pwa.modal.service;

import java.io.Serializable;
import java.util.List;
import co.gov.policia.pwa.modal.entity.CgRefCodesLista;

public interface CgRefCodesListaService extends Serializable{  

    public List<CgRefCodesLista> selectAllCgrefcodesLista();
    
    public List<CgRefCodesLista> selectCgRefCodesListaRol();
    
    public List<CgRefCodesLista> selectCgRefCodesListaNovedad();

}
