package co.gov.policia.pwa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import co.gov.policia.pwa.service.VwPwaAdmDisciplinasJecriService;
import co.gov.policia.pwa.entity.VwPwaAdmDisciplinasJecri1Lista;
import co.gov.policia.pwa.entity.VwPwaAdmDisciplinasJecri2Lista;
import co.gov.policia.pwa.entity.VwPwaUbicaDiciplixRegion;
import co.gov.policia.pwa.modal.entity.VwPwaProcedimientosJecriLista;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/admdisciplinasjecri")
public class VwPwaAdmDisciplinasJecriController {
    
    @Autowired
    VwPwaAdmDisciplinasJecriService vwPwaAdmDisciplinasJecriService;
    
    @GetMapping(value = "/selectAllLista1", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<VwPwaAdmDisciplinasJecri1Lista> selectAllVwPwaAdmDisciplinasJecri1Lista() {
        return vwPwaAdmDisciplinasJecriService.selectAllVwPwaAdmDisciplinasJecri1Lista();
    }
    
    @GetMapping(value = "/selectAllLista2", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<VwPwaAdmDisciplinasJecri2Lista> selectAllVwPwaAdmDisciplinasJecri2Lista(@RequestParam Long consecutivo) {
        return vwPwaAdmDisciplinasJecriService.selectAllVwPwaAdmDisciplinasJecri2Lista(consecutivo);
    }
    
    @GetMapping(value = "/selectListaProcedimientosJecri", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<VwPwaProcedimientosJecriLista> selectVwPwaProcedimientosJecri(@RequestParam Long consecutivo) {
        return vwPwaAdmDisciplinasJecriService.selectVwPwaProcedimientosJecri(consecutivo);
    }
    
    @GetMapping(value = "/selectVwPwaUbicaDiciplixRegion", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<VwPwaUbicaDiciplixRegion> selectVwPwaUbicaDiciplixRegion(@RequestParam Long idDisciplina) {
        return vwPwaAdmDisciplinasJecriService.selectVwPwaUbicaDiciplixRegion(idDisciplina);
    }

}
