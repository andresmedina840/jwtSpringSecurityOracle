package co.gov.policia.pwa.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import co.gov.policia.pwa.entity.GraCapacidadTecnicaLista;
import co.gov.policia.pwa.modal.entity.VwPwaSalasGracoLista;
import co.gov.policia.pwa.modal.payload.response.VwPwaSalasGracoListaResponse;
import co.gov.policia.pwa.payload.response.GraCapacidadTecnicaListaResponse;
import co.gov.policia.pwa.service.GraCapacidadTecnicaService;

@Service
public class GraCapacidadTecnicaImpl extends AbstractService implements GraCapacidadTecnicaService {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public ResponseEntity<?> salasReporteSeguimientoGraco(Long undeCodigoSipac, String usuarioNacional) {
		List<VwPwaSalasGracoLista> listadoSalasReporteGracoLista = new ArrayList<>();

		Long code = null;
		String mensaje = "";
		Query q = null;

		try {

			if (usuarioNacional.equals("SI")) {
				q = em.createNativeQuery(
						"select * from VW_PWA_SALAS_GRACO ORDER BY descripcion_dependencia", VwPwaSalasGracoLista.class);
			} else {
				q = em.createNativeQuery(
						"select * from VW_PWA_SALAS_GRACO WHERE CODIGO = ? ORDER BY descripcion_dependencia", VwPwaSalasGracoLista.class);

				q.setParameter(1, undeCodigoSipac);
			}

			listadoSalasReporteGracoLista = q.getResultList();
			
			if (listadoSalasReporteGracoLista.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado informacion";
			} else {
				code = 2L;
				mensaje = "No se ha encontrado información.";
				listadoSalasReporteGracoLista = new ArrayList<>();
			}

			Long totalResultados = (long) listadoSalasReporteGracoLista.size();

			return ResponseEntity.ok(
					new VwPwaSalasGracoListaResponse(listadoSalasReporteGracoLista, code, mensaje, totalResultados));
		} catch (Exception ex) {
			System.out.println("Error al consultar la información: " + ex.getMessage());
			return ResponseEntity.ok(ex.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public ResponseEntity<?> datosRepSeguimientoGraco(@RequestParam Long undeCodigoSipac) {
		List<GraCapacidadTecnicaLista> listadoGraCapacidadTecnica = new ArrayList<>();

		Query q = null;
		Long code = null;
		String mensaje = "";

		System.out.println("undeCodigoSipac: " + undeCodigoSipac);

		try {

			q = em.createNativeQuery("SELECT * FROM GRA_CAPACIDAD_TECNICA WHERE UNDE_CODIGO = ?");

			q.setParameter(1, undeCodigoSipac);

			List<Object[]> lstItems = (List<Object[]>) q.getResultList();
			
			int i = 0;
			for (Object[] obj : lstItems) {
				GraCapacidadTecnicaLista graCapacidadTecnicaLista = new GraCapacidadTecnicaLista();
				if (i < lstItems.size()) {
					
					String porcentajeFaltanteClaro = "";
					String porcentajeFaltanteMovistar = "";
					String porcentajeFaltanteTigo = "";
					String porcentajeFaltanteWom = "";
					String porcentajeFaltanteTotal = "";
					
					//Variables para calculo del operador Claro
					BigDecimal claroTotal = new BigDecimal(obj[2].toString());   										
					BigDecimal claroOcupado = new BigDecimal(obj[3].toString());  					
					
					float porcentajeClaro = (claroOcupado.floatValue() * 100)/claroTotal.floatValue();
					DecimalFormat claro = new DecimalFormat("#.#");
					
					porcentajeFaltanteClaro = claro.format(porcentajeClaro) + "%";
					
					//Variables para calculo del operador Movistar
					BigDecimal movistarTotal = new BigDecimal(obj[4].toString());   									
					BigDecimal movistarOcupado = new BigDecimal(obj[5].toString());  					
					
					float porcentajeMovistar = (movistarOcupado.floatValue() * 100)/movistarTotal.floatValue();
					DecimalFormat movistar = new DecimalFormat("#.#");
					
					porcentajeFaltanteMovistar = movistar.format(porcentajeMovistar) + "%";
					
					//Variables para calculo del operador Tigo
					BigDecimal tigoTotal = new BigDecimal(obj[6].toString());   					
					BigDecimal tigoOcupado = new BigDecimal(obj[7].toString());
					
					float porcentajeTigo = (tigoOcupado.floatValue() * 100)/tigoTotal.floatValue();
									
					DecimalFormat tigo = new DecimalFormat("#.#");
					porcentajeFaltanteTigo = tigo.format(porcentajeTigo) + "%";
					
					//Variables para calculo del operador Wom
					BigDecimal womTotal = new BigDecimal(obj[8].toString());   										
					BigDecimal womOcupado = new BigDecimal(obj[9].toString());  					
					
					float porcentajeWom = (womOcupado.floatValue() * 100)/womTotal.floatValue();
					DecimalFormat wom = new DecimalFormat("#.#");
					
					porcentajeFaltanteWom = wom.format(porcentajeWom) + "%";
					
					//Variables para calculo del operador Total
					BigDecimal total = new BigDecimal(obj[10].toString());   										
					BigDecimal totalOcupado = new BigDecimal(obj[11].toString());  					
					
					float porcentajeTotal = (totalOcupado.floatValue() * 100)/total.floatValue();
					DecimalFormat totalTotales = new DecimalFormat("#.#");
					
					porcentajeFaltanteTotal = totalTotales.format(porcentajeTotal) + "%";
									
					graCapacidadTecnicaLista.setConsecutivo(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
					graCapacidadTecnicaLista.setUndeCodigo(Long.parseLong(obj[1] == null ? null : obj[1].toString()));
					graCapacidadTecnicaLista.setTotalClaro(Long.parseLong(obj[2] == null ? null : obj[2].toString()));
					graCapacidadTecnicaLista.setOcupadoClaro(Long.parseLong(obj[3] == null ? null : obj[3].toString()));
					graCapacidadTecnicaLista.setTotalMovistar(Long.parseLong(obj[4] == null ? null : obj[4].toString()));
					graCapacidadTecnicaLista.setOcupadoMovistar(Long.parseLong(obj[5] == null ? null : obj[5].toString()));
					graCapacidadTecnicaLista.setTotalTigo(Long.parseLong(obj[6] == null ? null : obj[6].toString()));
					graCapacidadTecnicaLista.setOcupadoTigo(Long.parseLong(obj[7] == null ? null : obj[7].toString()));
					graCapacidadTecnicaLista.setTotalWom(Long.parseLong(obj[8] == null ? null : obj[8].toString()));
					graCapacidadTecnicaLista.setOcupadoWom(Long.parseLong(obj[9] == null ? null : obj[9].toString()));
					graCapacidadTecnicaLista.setTotalCapacidad(Long.parseLong(obj[10] == null ? null : obj[10].toString()));
					graCapacidadTecnicaLista.setTotalOcupado(Long.parseLong(obj[11] == null ? null : obj[11].toString()));
					graCapacidadTecnicaLista.setPorcentajeRestanteClaro(porcentajeFaltanteClaro == null ? null : porcentajeFaltanteClaro);
					graCapacidadTecnicaLista.setPorcentajeRestanteMovistar(porcentajeFaltanteMovistar == null ? null : porcentajeFaltanteMovistar);
					graCapacidadTecnicaLista.setPorcentajeRestanteTigo(porcentajeFaltanteTigo == null ? null : porcentajeFaltanteTigo);
					graCapacidadTecnicaLista.setPorcentajeRestanteWom(porcentajeFaltanteWom == null ? null : porcentajeFaltanteWom);
					graCapacidadTecnicaLista.setPorcentajeRestanteTotales(porcentajeFaltanteTotal == null ? null : porcentajeFaltanteTotal);
				}
				listadoGraCapacidadTecnica.add(graCapacidadTecnicaLista);
				i = i + 1;
			}

			if (listadoGraCapacidadTecnica.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado informacion";
			} else {
				code = 2L;
				mensaje = "No se ha encontrado información.";
				listadoGraCapacidadTecnica = new ArrayList<>();
			}

			Long totalResultados = (long) listadoGraCapacidadTecnica.size();

			return ResponseEntity.ok(
					new GraCapacidadTecnicaListaResponse(listadoGraCapacidadTecnica, code, mensaje, totalResultados));
		} catch (Exception ex) {
			System.out.println("Error al consultar: " + ex.getMessage());
			return ResponseEntity.ok(ex.getMessage());
		}
	}

}
