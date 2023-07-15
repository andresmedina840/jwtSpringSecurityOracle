package co.gov.policia.pwa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.gov.policia.pwa.entity.VwPwaUbicacionDisciplinas;
import co.gov.policia.pwa.modal.entity.UbicacionJecriLista;
import co.gov.policia.pwa.service.VwPwaUbicacionDisciplinasService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/vwpwaubicaciondisciplinas")
public class VwPwaUbicacionDisciplinasController {
    
    @Autowired
    VwPwaUbicacionDisciplinasService vwPwaUbicacionDisciplinasService;
    
    @GetMapping(value = "/selectVwPwaUbicacionDisciplinas", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<UbicacionJecriLista> selectUbicacionJecriLista(@RequestParam Long idDisciplina) {
        return vwPwaUbicacionDisciplinasService.selectUbicacionJecriLista(idDisciplina);
    }
    
    @GetMapping(value = "/selectVwPwaUbicacionDisciplinasByCodigoRegional", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<VwPwaUbicacionDisciplinas> selectVwPwaUbicacionDisciplinasByCodigoRegional(@RequestParam Long idDisciplina, Long codigoRegional) {
        return vwPwaUbicacionDisciplinasService.selectVwPwaUbicacionDisciplinasByCodigoRegional(idDisciplina, codigoRegional);
    }

}
