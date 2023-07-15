package co.gov.policia.pwa.modal.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.http.ResponseEntity;
import co.gov.policia.pwa.modal.entity.CiudadLista;
import co.gov.policia.pwa.modal.entity.DepartamentosLista;
import co.gov.policia.pwa.modal.entity.PaisLista;
import co.gov.policia.pwa.modal.entity.ProcesoInvestigativoLista;

public interface FuentesHumanasListaService  extends Serializable {  
  
    public ResponseEntity<?> fuentesHumanasByUsuario(Long consecutivo);
    
    public List<ProcesoInvestigativoLista> procesoInvetigativoByNroUnico(String nroUnico);
    
    public ResponseEntity<?> invetigadoresByIdentificacion(Long identificacion);
    
    public ResponseEntity<?> invetigadores2ByIdentificacion2(Long identificacion, Long identificacion2);
    
    public List<PaisLista> selectAllPais();
    
    public List<DepartamentosLista> departamentoByCodigoPais(Long codigoPais);
    
    public List<CiudadLista> ciudadByCodigoDepartamento(Long codigoDepartamento);

}
