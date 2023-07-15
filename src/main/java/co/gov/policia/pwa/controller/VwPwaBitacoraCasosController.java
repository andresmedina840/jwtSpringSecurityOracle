package co.gov.policia.pwa.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;
import co.gov.policia.pwa.entity.VwPwaBitacoraCasos;
import co.gov.policia.pwa.service.VwPwaBitacoraCasosService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/vwpwabitacoracasos")
public class VwPwaBitacoraCasosController {      
    
    @Lazy
    @Autowired
    VwPwaBitacoraCasosService vwPwaBitacoraCasosService;
    
    @PostMapping(value = "/insert", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> insertVwPwaBitacoraCasos(@RequestBody VwPwaBitacoraCasos vwPwaBitacoraCasos) {
        
        String usuarioConexion = SecurityContextHolder.getContext().getAuthentication().getName();

        return vwPwaBitacoraCasosService.insertVwPwaBitacoraCasos(vwPwaBitacoraCasos, usuarioConexion);	
    } 

}