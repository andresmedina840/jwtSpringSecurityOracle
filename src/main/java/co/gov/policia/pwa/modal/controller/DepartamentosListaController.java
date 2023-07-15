package co.gov.policia.pwa.modal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.gov.policia.pwa.modal.entity.DepartamentosLista;
import co.gov.policia.pwa.modal.entity.MunicipiosLista;
import co.gov.policia.pwa.modal.service.DepartamentosListaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/departamentoslista")
public class DepartamentosListaController {
    
    @Autowired
    DepartamentosListaService departamentosListaService;
    
    @GetMapping(value = "/departamentos", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<DepartamentosLista> selectAllDepartamentos() {
        return departamentosListaService.selectAllDepartamentos();
    }
    
    @GetMapping(value = "/municipios", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<MunicipiosLista> selectMunicipiosByDepartamentoId(Long departamentoId) {
        return departamentosListaService.selectMunicipiosByDepartamentoId(departamentoId);
    }

}
