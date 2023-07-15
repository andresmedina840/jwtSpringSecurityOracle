package co.gov.policia.pwa.modal.services.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.modal.entity.CasosFuncionalidades;
import co.gov.policia.pwa.modal.payload.response.FuncionariosListaResponse;
import co.gov.policia.pwa.modal.service.NoticiaCriminalListaService;
import co.gov.policia.pwa.service.impl.AbstractService;

@Service
public class FuncionariosListaImpl extends AbstractService implements NoticiaCriminalListaService{
	
	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> leyesFuncionarios() {
		List<CasosFuncionalidades> listadoCasosFuncionalidades = new ArrayList<>();
		
		Long code = null;
		String mensaje = "";

		Query q = null;

		try {

			q = em.createNativeQuery("select * from CASOS_FUNCIONALIDADES WHERE tipo_variable = 'LEYES' AND ESTADO = 'AC' order by descripcion",
					CasosFuncionalidades.class);

			listadoCasosFuncionalidades = q.getResultList();

			if (listadoCasosFuncionalidades.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado informacion";

			} else {
				code = 2L;
				mensaje = "No se ha encontrado información.";
				listadoCasosFuncionalidades = new ArrayList<>();
			}

			Long totalResultados = (long) listadoCasosFuncionalidades.size();

			return ResponseEntity.ok(new FuncionariosListaResponse(listadoCasosFuncionalidades, code, mensaje, totalResultados));
		} catch (Exception ex) {
			return ResponseEntity.ok(ex.getMessage());
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> lineaNoticiaCriminal() {
		List<CasosFuncionalidades> listadoCasosFuncionalidades = new ArrayList<>();
		
		Long code = null;
		String mensaje = "";

		Query q = null;

		try {

			q = em.createNativeQuery("select * from CASOS_FUNCIONALIDADES WHERE tipo_variable = 'LEYES' AND ESTADO = 'AC' order by descripcion",
					CasosFuncionalidades.class);

			listadoCasosFuncionalidades = q.getResultList();

			if (listadoCasosFuncionalidades.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado informacion";

			} else {
				code = 2L;
				mensaje = "No se ha encontrado información.";
				listadoCasosFuncionalidades = new ArrayList<>();
			}

			Long totalResultados = (long) listadoCasosFuncionalidades.size();

			return ResponseEntity.ok(new FuncionariosListaResponse(listadoCasosFuncionalidades, code, mensaje, totalResultados));
		} catch (Exception ex) {
			return ResponseEntity.ok(ex.getMessage());
		}
	}
	

}
