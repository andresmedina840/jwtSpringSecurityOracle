package co.gov.policia.pwa.modal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.gov.policia.pwa.modal.service.NoticiaCriminalListaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/noticiaCrimialLista")
public class NoticiaCriminalListaController {
	
	@Autowired
	NoticiaCriminalListaService noticiaCriminalListaService;
	
	@GetMapping(value = "/leyesFuncionarios", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> leyesFuncionarios()  {
        return noticiaCriminalListaService.leyesFuncionarios();
    }

}
