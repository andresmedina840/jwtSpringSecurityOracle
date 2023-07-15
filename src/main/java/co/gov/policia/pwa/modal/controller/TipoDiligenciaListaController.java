package co.gov.policia.pwa.modal.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.gov.policia.pwa.modal.entity.ClasificacionLista;
import co.gov.policia.pwa.modal.entity.TipoDiligenciaLista;
import co.gov.policia.pwa.modal.service.TipoDiligenciaListaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/tipodiligencialista")
public class TipoDiligenciaListaController {

    @Autowired
    TipoDiligenciaListaService tipoDiligenciaListaService;

    @GetMapping(value = "/tipoDiligencia", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<TipoDiligenciaLista> selectAllTipoDiligenciaLista() {
        return tipoDiligenciaListaService.selectAllTipoDiligenciaLista();
    }
    
    @GetMapping(value = "/prueba", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Map<String, String> selectAllTipoDiligenciaLista1() {
        return tipoDiligenciaListaService.selectAllTipoDiligenciaLista1();
    }
    
    @GetMapping(value = "/prueba2", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<ClasificacionLista> selectAllTipoDiligenciaLista2() {
        return tipoDiligenciaListaService.selectAllTipoDiligenciaLista2();
    }

}
