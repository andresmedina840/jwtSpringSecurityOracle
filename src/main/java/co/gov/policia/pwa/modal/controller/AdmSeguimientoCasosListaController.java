package co.gov.policia.pwa.modal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.gov.policia.pwa.modal.entity.AdmSeguimientoCasosLista;
import co.gov.policia.pwa.modal.service.AdmSeguimientoCasosListaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/admseguimientocasoslista")
public class AdmSeguimientoCasosListaController {
    
    @Autowired
    AdmSeguimientoCasosListaService admSeguimientoCasosListaService;
    
    @GetMapping(value = "/admlistaconductasAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<AdmSeguimientoCasosLista> selectAllAdmSeguimientoCasosLista()  {
        return admSeguimientoCasosListaService.selectAllAdmSeguimientoCasosLista();
    }
    
    @GetMapping(value = "/consCaso", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> selectAllAdmSeguimientoCasosListaByConsCaso(Long consCaso)  {
        return admSeguimientoCasosListaService.selectAllAdmSeguimientoCasosListaByConsCaso(consCaso);
    }

}
