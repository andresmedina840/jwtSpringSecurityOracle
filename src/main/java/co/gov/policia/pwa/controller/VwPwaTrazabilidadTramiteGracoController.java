package co.gov.policia.pwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.gov.policia.pwa.service.VwPwaTrazabilidadTramiteGracoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/vwpwatrazabilidadtramitegraco")
public class VwPwaTrazabilidadTramiteGracoController {
	
    @Autowired
    VwPwaTrazabilidadTramiteGracoService vwPwaTrazabilidadTramiteGracoService;
    
    @GetMapping(value = "/consultaTrazabilidadTramiteGraco", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> consultaTrazabilidadTramiteGraco(@RequestParam Long consecutivo) {
        return vwPwaTrazabilidadTramiteGracoService.consultaTrazabilidadTramiteGraco(consecutivo);
    }

}
