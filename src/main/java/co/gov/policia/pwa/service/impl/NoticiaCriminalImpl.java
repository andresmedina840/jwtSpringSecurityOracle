package co.gov.policia.pwa.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.entity.Anios;
import co.gov.policia.pwa.entity.VwCasosFuncionarios;
import co.gov.policia.pwa.modal.entity.CasosFuncionalidades;
import co.gov.policia.pwa.payload.response.CasosFuncionalidadesResponse;
import co.gov.policia.pwa.payload.response.VwCasosFuncionariosResponse;
import co.gov.policia.pwa.service.NoticiaCriminalService;

@Service
public class NoticiaCriminalImpl extends AbstractService implements NoticiaCriminalService {

	@Lazy
	@Autowired
	NoticiaCriminalService noticiaCriminalService;

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> buscarNoticiaCriminalFinal(String nroUnico) {
		List<VwCasosFuncionarios> listadoVwCasosFuncionarios = new ArrayList<>();
		Long code = null;
		String mensaje = "";

		Query q = null;

		try {

			q = em.createNativeQuery("select * from VW_CASOS_FUNCIONARIOS where nro_unico = ?",
					VwCasosFuncionarios.class);

			q.setParameter(1, nroUnico.trim());

			listadoVwCasosFuncionarios = q.getResultList();

			if (listadoVwCasosFuncionarios.size() > 0) {
				code = -1L;
				mensaje = "La noticia criminal ya existe, asigne otro numero de noticia criminal.";

			} else {
				code = 0L;
				mensaje = "No se ha encontrado información.";
				listadoVwCasosFuncionarios = new ArrayList<>();
			}

			Long totalResultados = (long) listadoVwCasosFuncionarios.size();

			return ResponseEntity
					.ok(new VwCasosFuncionariosResponse(listadoVwCasosFuncionarios, code, mensaje, totalResultados));
		} catch (Exception ex) {
			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> listaClasificacion() {
		List<CasosFuncionalidades> listadoCasosFuncionalidades = new ArrayList<>();
		Long code = null;
		String mensaje = "";

		Query q = null;

		try {

			q = em.createNativeQuery(
					"select * from casos_funcionalidades where tipo_variable = 'CLASIFICACION' and estado = 'AC' order by descripcion",
					CasosFuncionalidades.class);

			listadoCasosFuncionalidades = q.getResultList();

			if (listadoCasosFuncionalidades.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado informacion.";

			} else {
				code = -1L;
				mensaje = "No se ha encontrado información.";
				listadoCasosFuncionalidades = new ArrayList<>();
			}

			Long totalResultados = (long) listadoCasosFuncionalidades.size();

			return ResponseEntity
					.ok(new CasosFuncionalidadesResponse(listadoCasosFuncionalidades, code, mensaje, totalResultados));
		} catch (Exception ex) {
			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> listaEstadoMored() {
		List<CasosFuncionalidades> listadoCasosFuncionalidades = new ArrayList<>();
		Long code = null;
		String mensaje = "";

		Query q = null;

		try {

			q = em.createNativeQuery(
					"select * from casos_funcionalidades where tipo_variable = 'ESTADO_MORED' and estado = 'AC' order by descripcion",
					CasosFuncionalidades.class);

			listadoCasosFuncionalidades = q.getResultList();

			if (listadoCasosFuncionalidades.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado informacion.";

			} else {
				code = -1L;
				mensaje = "No se ha encontrado información.";
				listadoCasosFuncionalidades = new ArrayList<>();
			}

			Long totalResultados = (long) listadoCasosFuncionalidades.size();

			return ResponseEntity
					.ok(new CasosFuncionalidadesResponse(listadoCasosFuncionalidades, code, mensaje, totalResultados));
		} catch (Exception ex) {
			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> listaPriorizado() {
		List<CasosFuncionalidades> listadoCasosFuncionalidades = new ArrayList<>();
		Long code = null;
		String mensaje = "";

		Query q = null;

		try {

			q = em.createNativeQuery(
					"select * from casos_funcionalidades where tipo_variable = 'PRIORIZADO' and estado = 'AC' order by descripcion",
					CasosFuncionalidades.class);

			listadoCasosFuncionalidades = q.getResultList();

			if (listadoCasosFuncionalidades.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado informacion.";

			} else {
				code = -1L;
				mensaje = "No se ha encontrado información.";
				listadoCasosFuncionalidades = new ArrayList<>();
			}

			Long totalResultados = (long) listadoCasosFuncionalidades.size();

			return ResponseEntity
					.ok(new CasosFuncionalidadesResponse(listadoCasosFuncionalidades, code, mensaje, totalResultados));
		} catch (Exception ex) {
			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> listaBlancoEstrategico() {
		List<CasosFuncionalidades> listadoCasosFuncionalidades = new ArrayList<>();
		Long code = null;
		String mensaje = "";

		Query q = null;

		try {

			q = em.createNativeQuery(
					"select * from casos_funcionalidades where tipo_variable = 'BLANCO_ESTRATEGICO' and estado = 'AC' order by descripcion",
					CasosFuncionalidades.class);

			listadoCasosFuncionalidades = q.getResultList();

			if (listadoCasosFuncionalidades.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado informacion.";

			} else {
				code = -1L;
				mensaje = "No se ha encontrado información.";
				listadoCasosFuncionalidades = new ArrayList<>();
			}

			Long totalResultados = (long) listadoCasosFuncionalidades.size();

			return ResponseEntity
					.ok(new CasosFuncionalidadesResponse(listadoCasosFuncionalidades, code, mensaje, totalResultados));
		} catch (Exception ex) {
			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> listaEstrategiaMored() {
		List<CasosFuncionalidades> listadoCasosFuncionalidades = new ArrayList<>();
		Long code = null;
		String mensaje = "";

		Query q = null;

		try {

			q = em.createNativeQuery(
					"select * from casos_funcionalidades where tipo_variable = 'ESTRATEGIA_MORED' and estado = 'AC' order by descripcion",
					CasosFuncionalidades.class);

			listadoCasosFuncionalidades = q.getResultList();

			if (listadoCasosFuncionalidades.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado informacion.";

			} else {
				code = -1L;
				mensaje = "No se ha encontrado información.";
				listadoCasosFuncionalidades = new ArrayList<>();
			}

			Long totalResultados = (long) listadoCasosFuncionalidades.size();

			return ResponseEntity
					.ok(new CasosFuncionalidadesResponse(listadoCasosFuncionalidades, code, mensaje, totalResultados));
		} catch (Exception ex) {
			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> listaAvanceMored() {
		List<CasosFuncionalidades> listadoCasosFuncionalidades = new ArrayList<>();
		Long code = null;
		String mensaje = "";

		Query q = null;

		try {

			q = em.createNativeQuery(
					"select * from casos_funcionalidades where tipo_variable = 'AVANCE_MORED' and estado = 'AC' order by descripcion",
					CasosFuncionalidades.class);

			listadoCasosFuncionalidades = q.getResultList();

			if (listadoCasosFuncionalidades.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado informacion.";

			} else {
				code = -1L;
				mensaje = "No se ha encontrado información.";
				listadoCasosFuncionalidades = new ArrayList<>();
			}

			Long totalResultados = (long) listadoCasosFuncionalidades.size();

			return ResponseEntity
					.ok(new CasosFuncionalidadesResponse(listadoCasosFuncionalidades, code, mensaje, totalResultados));
		} catch (Exception ex) {
			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> listaEstado() {
		List<CasosFuncionalidades> listadoCasosFuncionalidades = new ArrayList<>();
		Long code = null;
		String mensaje = "";

		Query q = null;

		try {

			q = em.createNativeQuery(
					"select * from casos_funcionalidades where tipo_variable = 'ESTADO' and estado = 'AC' order by descripcion",
					CasosFuncionalidades.class);

			listadoCasosFuncionalidades = q.getResultList();

			if (listadoCasosFuncionalidades.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado informacion.";

			} else {
				code = -1L;
				mensaje = "No se ha encontrado información.";
				listadoCasosFuncionalidades = new ArrayList<>();
			}

			Long totalResultados = (long) listadoCasosFuncionalidades.size();

			return ResponseEntity
					.ok(new CasosFuncionalidadesResponse(listadoCasosFuncionalidades, code, mensaje, totalResultados));
		} catch (Exception ex) {
			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> listaZonas() {
		List<CasosFuncionalidades> listadoCasosFuncionalidades = new ArrayList<>();
		Long code = null;
		String mensaje = "";

		Query q = null;

		try {

			q = em.createNativeQuery(
					"select * from casos_funcionalidades where tipo_variable = 'ZONAS' and estado = 'AC' order by descripcion",
					CasosFuncionalidades.class);

			listadoCasosFuncionalidades = q.getResultList();

			if (listadoCasosFuncionalidades.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado informacion.";

			} else {
				code = -1L;
				mensaje = "No se ha encontrado información.";
				listadoCasosFuncionalidades = new ArrayList<>();
			}

			Long totalResultados = (long) listadoCasosFuncionalidades.size();

			return ResponseEntity
					.ok(new CasosFuncionalidadesResponse(listadoCasosFuncionalidades, code, mensaje, totalResultados));
		} catch (Exception ex) {
			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public List<Anios> selectAnios() {

		List<Anios> listadoFinalAnios = new ArrayList<>();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy", new Locale("es", "CO"));
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));

		String anioActual = dateFormat.format(new Date());

		Long anioActualFinal = Long.parseLong(anioActual);
				
		Long aniosAsignar = null;
		int anioInicia = 1983;

		for (long i = anioInicia; i <= anioActualFinal; i++) {
			
			//System.out.println(i);
			
			aniosAsignar = i;
			System.out.println("aniosAsignar: " + aniosAsignar);
			
			String aniosAsignarString = aniosAsignar.toString();
			Anios listaAnios = new Anios();
			
			if (i <= anioActualFinal) {
				listaAnios.setAnio(aniosAsignarString);
			}
			
			listadoFinalAnios.add(listaAnios);
			aniosAsignar = aniosAsignar + 1L;

		}
		
		System.out.println("Total de años: " + listadoFinalAnios.size());

		return listadoFinalAnios;
	}

}
