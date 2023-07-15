package co.gov.policia.pwa.modal.service;

import java.io.Serializable;
import java.util.List;
import co.gov.policia.pwa.modal.entity.DepartamentosLista;
import co.gov.policia.pwa.modal.entity.MunicipiosLista;

public interface DepartamentosListaService extends Serializable{  

    public List<DepartamentosLista> selectAllDepartamentos();
    
    public List<MunicipiosLista> selectMunicipiosByDepartamentoId(Long departamentoId);

}
