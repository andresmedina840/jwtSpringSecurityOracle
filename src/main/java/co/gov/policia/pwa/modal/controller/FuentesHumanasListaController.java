package co.gov.policia.pwa.modal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.gov.policia.pwa.modal.entity.CiudadLista;
import co.gov.policia.pwa.modal.entity.DepartamentosLista;
import co.gov.policia.pwa.modal.entity.PaisLista;
import co.gov.policia.pwa.modal.entity.ProcesoInvestigativoLista;
import co.gov.policia.pwa.modal.service.FuentesHumanasListaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/fuenteshumanaslista")
public class FuentesHumanasListaController {
    
    @Autowired
    FuentesHumanasListaService fuentesHumanasListaService;
       
    @GetMapping(value = "/fuentesHumanasByUsuario", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> fuentesHumanasByUsuario(@RequestParam Long consecutivo) {
        return fuentesHumanasListaService.fuentesHumanasByUsuario(consecutivo);
    }
    
    @GetMapping(value = "/procesoInvetigativoByNroUnico", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<ProcesoInvestigativoLista> procesoInvetigativoByNroUnico(String nroUnico) {
        return fuentesHumanasListaService.procesoInvetigativoByNroUnico(nroUnico);
    }
     
    @GetMapping(value = "/invetigadoresByIdentificacion", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> invetigadoresByIdentificacion(Long identificacion) {
    	return fuentesHumanasListaService.invetigadoresByIdentificacion(identificacion);
    }
    
    @GetMapping(value = "/invetigadores2ByIdentificacion2", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> invetigadores2ByIdentificacion2(Long identificacion, Long identificacion2) {    
        return fuentesHumanasListaService.invetigadores2ByIdentificacion2(identificacion, identificacion2);
    }
    
    @GetMapping(value = "/selectAllPais", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<PaisLista> selectAllPais() {
        return fuentesHumanasListaService.selectAllPais();
    }
    
    @GetMapping(value = "/departamentoByCodigoPais", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<DepartamentosLista> departamentoByCodigoPais(Long codigoPais) {
        return fuentesHumanasListaService.departamentoByCodigoPais(codigoPais);
    }
    
    @GetMapping(value = "/ciudadByCodigoDepartamento", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<CiudadLista> ciudadByCodigoDepartamento(Long codigoDepartamento) {
        return fuentesHumanasListaService.ciudadByCodigoDepartamento(codigoDepartamento);
    }

}
