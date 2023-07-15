package co.gov.policia.pwa.modal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.gov.policia.pwa.modal.entity.VwLugaresLista;
import co.gov.policia.pwa.modal.service.VwLugaresListaService;


@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/vwlugareslista")
public class VwLugaresListaController {
    
    @Autowired
    VwLugaresListaService vwLugaresListaService;
    
    @GetMapping(value = "/vwlugaresAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<VwLugaresLista> selectAllVwLugaresLista() {
        return vwLugaresListaService.selectAllVwLugaresLista();
    }

}
