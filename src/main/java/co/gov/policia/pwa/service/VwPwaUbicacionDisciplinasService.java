package co.gov.policia.pwa.service;

import java.io.Serializable;
import java.util.List;
import co.gov.policia.pwa.entity.VwPwaUbicacionDisciplinas;
import co.gov.policia.pwa.modal.entity.UbicacionJecriLista;

public interface VwPwaUbicacionDisciplinasService extends Serializable {
    
    public List<UbicacionJecriLista> selectUbicacionJecriLista(Long idDisciplina);
    
    public List<VwPwaUbicacionDisciplinas> selectVwPwaUbicacionDisciplinasByCodigoRegional(Long idDisciplina, Long codigoRegional);

}
