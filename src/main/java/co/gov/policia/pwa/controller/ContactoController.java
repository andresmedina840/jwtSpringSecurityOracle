package co.gov.policia.pwa.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import co.gov.policia.pwa.entity.Contacto;
import co.gov.policia.pwa.repository.ContactoRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/contactos")
@AllArgsConstructor
public class ContactoController {
	
	private final ContactoRepository contactoRepository;
	
	@GetMapping
	public List<Contacto> listContacto(){
		return contactoRepository.findAll();
	}

}
