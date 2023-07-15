package co.gov.policia.pwa.modal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.gov.policia.pwa.modal.entity.AmbitoDiaDiaLista;
import co.gov.policia.pwa.modal.service.AmbitoDiaDiaListaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/ambitodiadialista")
public class AmbitoDiaDiaListaController {
    
    @Autowired
    AmbitoDiaDiaListaService ambitoDiaDiaListaService;
    
    @GetMapping(value = "/ambitosAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<AmbitoDiaDiaLista> selectAllAmbitoDiaDiaLista()  {
        return ambitoDiaDiaListaService.selectAllAmbitoDiaDiaLista();
    }
    
    @GetMapping(value = "/actividadRealizadaByConsecutivo", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<AmbitoDiaDiaLista> actividadRealizadaByConsucutivo(String consecutivo)  {
        return ambitoDiaDiaListaService.actividadRealizadaByConsucutivo(consecutivo);
    }
    
    @GetMapping(value = "/descripcionActividadRealizadaByConsecutivo", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> descripcionActividadRealizadaByConsucutivo(String consecutivo)  {
        return ambitoDiaDiaListaService.descripcionActividadRealizadaByConsucutivo(consecutivo);
    }
    
}
