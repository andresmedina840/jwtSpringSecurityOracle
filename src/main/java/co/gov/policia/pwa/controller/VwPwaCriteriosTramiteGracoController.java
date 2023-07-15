package co.gov.policia.pwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.gov.policia.pwa.service.VwPwaCriteriosTramiteGracoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/vwpwacriteriostramitegraco")
public class VwPwaCriteriosTramiteGracoController {
	
    @Autowired
    VwPwaCriteriosTramiteGracoService vwPwaCriteriosTramiteGracoService;
    
    @GetMapping(value = "/verTabCriterios", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> verTabCriterios(@RequestParam Long consecutivo) {
        return vwPwaCriteriosTramiteGracoService.verTabCriterios(consecutivo);
    }

}
