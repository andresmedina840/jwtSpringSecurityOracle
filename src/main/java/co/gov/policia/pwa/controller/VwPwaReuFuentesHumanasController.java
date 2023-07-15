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
import co.gov.policia.pwa.entity.VwPwaReuFuentesHumanas;
import co.gov.policia.pwa.service.VwPwaReuFuentesHumanasService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/vwpwareufuenteshumanas")
public class VwPwaReuFuentesHumanasController {

    @Lazy
    @Autowired
    VwPwaReuFuentesHumanasService vwPwaReuFuentesHumanasService;

    @PostMapping(value = "/insertContactoFuntesHumanas", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> insertVwPwaReuFuentex(@RequestBody VwPwaReuFuentesHumanas vwPwaReuFuentesHumanas) {

        String usuarioConexion = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("usuarioConexion en el controlador: " + usuarioConexion);

        return vwPwaReuFuentesHumanasService.insertVwPwaReuFuentex(vwPwaReuFuentesHumanas, usuarioConexion);
    }

}