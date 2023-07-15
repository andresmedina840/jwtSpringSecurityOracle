package co.gov.policia.pwa.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;
import co.gov.policia.pwa.entity.VwPwaSeguimientoCasos;
import co.gov.policia.pwa.service.VwPwaSeguimientoCasosService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/vwpwaseguimientocasos")
public class VwPwaSeguimientoCasosController {

    @Autowired
    VwPwaSeguimientoCasosService vwPwaSeguimientoCasosService;
    
    @PostMapping(value = "/insertSeguimientoCasos", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> insertVwPwaSeguimienf(@RequestBody VwPwaSeguimientoCasos vwPwaSeguimientoCasos) {

        String usuarioConexion = SecurityContextHolder.getContext().getAuthentication().getName();

        return vwPwaSeguimientoCasosService.insertVwPwaSeguimientoCasos(vwPwaSeguimientoCasos, usuarioConexion);
    }

    @PutMapping(value = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> updateVwPwaSeguimienf(@RequestBody VwPwaSeguimientoCasos vwPwaSeguimientoCasos) {

        String usuarioConexion = SecurityContextHolder.getContext().getAuthentication().getName();

        return vwPwaSeguimientoCasosService.updateVwPwaSeguimientoCasos(vwPwaSeguimientoCasos, usuarioConexion);
    }

    @DeleteMapping(value = "/delete", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> deleteVwPwaSeguimienf(@RequestBody VwPwaSeguimientoCasos vwPwaSeguimientoCasos) {

        String usuarioConexion = SecurityContextHolder.getContext().getAuthentication().getName();

        return vwPwaSeguimientoCasosService.deleteVwPwaSeguimientoCasos(vwPwaSeguimientoCasos, usuarioConexion);
    }

    @GetMapping(value = "/select-by-id", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> selectVwPwaSeguimienfByConsCaso(Long conscaso) {
        return vwPwaSeguimientoCasosService.selectVwPwaSeguimientoCasosByConsCaso(conscaso);
    }

    @GetMapping(value = "/select-by-id-like", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> selectVwPwaSeguimienfByConsCasoLike(Long conscaso) {
        return vwPwaSeguimientoCasosService.selectVwPwaSeguimientoCasosByConsCasoLike(conscaso);
    }

    @GetMapping(value = "/selectAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<VwPwaSeguimientoCasos> getVwPwaSeguimienf() {
        return vwPwaSeguimientoCasosService.selectAllVwPwaSeguimientoCasos();
    }

}