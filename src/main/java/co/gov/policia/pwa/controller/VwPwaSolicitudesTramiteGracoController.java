package co.gov.policia.pwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.gov.policia.pwa.service.VwPwaSolicitudesTramiteGracoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/vwpwasolicitudestramitegraco")
public class VwPwaSolicitudesTramiteGracoController {
	
    @Autowired
    VwPwaSolicitudesTramiteGracoService vwPwaSolicitudesTramiteGracoService;
    
    @GetMapping(value = "/countSolicitudesTramiteGraco", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> countVwPwaSolicitudesTramiteGraco(@RequestParam Long salaCodigo, Long consEmpSala) {
        return vwPwaSolicitudesTramiteGracoService.countVwPwaSolicitudesTramiteGraco(salaCodigo, consEmpSala);
    }
    
    @GetMapping(value = "/datosTablaSolicitudesTramiteGraco", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> datosTablaSolicitudesTramiteGraco(@RequestParam Long salaCodigo, Long consEmpSala) {
        return vwPwaSolicitudesTramiteGracoService.datosTablaSolicitudesTramiteGraco(salaCodigo, consEmpSala);
    }
    
    @GetMapping(value = "/verDatosTablaSolicitudesTramiteGraco", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> verDatosTablaSolicitudesTramiteGraco(@RequestParam Long consecutivo) {
        return vwPwaSolicitudesTramiteGracoService.verDatosTablaSolicitudesTramiteGraco(consecutivo);
    }

}
