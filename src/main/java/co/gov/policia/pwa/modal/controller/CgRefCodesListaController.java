package co.gov.policia.pwa.modal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.gov.policia.pwa.modal.entity.CgRefCodesLista;
import co.gov.policia.pwa.modal.service.CgRefCodesListaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/cgrefcodeslista")
public class CgRefCodesListaController {
    
    @Autowired
    CgRefCodesListaService cgRefCodesListaService;
    
    @GetMapping(value = "/cgrefcodesAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<CgRefCodesLista> selectAllEntidad() {
        return cgRefCodesListaService.selectAllCgrefcodesLista();
    }
    
    @GetMapping(value = "/cgrefcodesRol", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<CgRefCodesLista> selectCgRefCodesListaRol() {
        return cgRefCodesListaService.selectCgRefCodesListaRol();
    }
    
    @GetMapping(value = "/cgrefcodesNovedad", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<CgRefCodesLista> selectCgRefCodesListaNovedad() {
        return cgRefCodesListaService.selectCgRefCodesListaNovedad();
    }

}
