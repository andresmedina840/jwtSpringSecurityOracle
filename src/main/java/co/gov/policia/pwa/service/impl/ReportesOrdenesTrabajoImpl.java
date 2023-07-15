package co.gov.policia.pwa.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.service.ReportesOrdenesTrabajoService;
import co.gov.policia.pwa.entity.Anios;
import co.gov.policia.pwa.entity.Grafica1ReporteOrdenesTrabajo;
import co.gov.policia.pwa.entity.Grafica3ReporteOrdenesTrabajo;
import co.gov.policia.pwa.entity.MesesReporteOrdenesTrabajo;
import co.gov.policia.pwa.entity.ReportesOrdenesTrabajo;
import co.gov.policia.pwa.entity.VwPwaAdminUsuariosNacional;
import co.gov.policia.pwa.payload.response.AniosResponse;
import co.gov.policia.pwa.payload.response.Grafica1ReporteOrdenesTrabajoResponse;
import co.gov.policia.pwa.payload.response.Grafica3ReporteOrdenesTrabajoResponse;
import co.gov.policia.pwa.payload.response.MesesReporteOrdenesTrabajoResponse;
import co.gov.policia.pwa.payload.response.ReportesOrdenesTrabajoResponse;

@Service
public class ReportesOrdenesTrabajoImpl extends AbstractService implements ReportesOrdenesTrabajoService {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public ResponseEntity<?> regionalRepOrdenesTrabajoEstado(String regional, String usuarioNacional) {
		List<ReportesOrdenesTrabajo> listadoReportesOrdenesTrabajo = new ArrayList<>();

		Long code = null;
		String mensaje = "";
		Query q = null;

		try {
			
			if (usuarioNacional.equals("SI")) {
				q = em.createNativeQuery(
						"SELECT REGIONAL FROM REP_ORDENES_TRABAJO_ESTADO GROUP BY REGIONAL ORDER BY REGIONAL");
			} else {
				q = em.createNativeQuery(
						"SELECT REGIONAL FROM REP_ORDENES_TRABAJO_ESTADO WHERE REGIONAL = ? GROUP BY REGIONAL ORDER BY REGIONAL");

				q.setParameter(1, regional);
			}
			
			listadoReportesOrdenesTrabajo = q.getResultList();

			if (listadoReportesOrdenesTrabajo.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado informacion";
			} else {
				code = 2L;
				mensaje = "No se ha encontrado información.";
				listadoReportesOrdenesTrabajo = new ArrayList<>();
			}

			Long totalResultados = (long) listadoReportesOrdenesTrabajo.size();

			return ResponseEntity.ok(new ReportesOrdenesTrabajoResponse(listadoReportesOrdenesTrabajo, null, code,
					mensaje, totalResultados));
		} catch (Exception ex) {
			System.out.println("Error al consultar la información: " + ex.getMessage());
			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public ResponseEntity<?> unidadRepOrdenesTrabajoEstado(String regional) {
		List<ReportesOrdenesTrabajo> listadoReportesOrdenesTrabajo = new ArrayList<>();

		Long code = null;
		String mensaje = "";

		try {
			Query q = em.createNativeQuery(
					"SELECT UNIDAD FROM REP_ORDENES_TRABAJO_ESTADO where regional = ? group by unidad order by unidad");

			q.setParameter(1, regional);

			listadoReportesOrdenesTrabajo = q.getResultList();

			if (listadoReportesOrdenesTrabajo.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado informacion";
			} else {
				code = 2L;
				mensaje = "No se ha encontrado información.";
				listadoReportesOrdenesTrabajo = new ArrayList<>();
			}

			Long totalResultados = (long) listadoReportesOrdenesTrabajo.size();

			return ResponseEntity.ok(new ReportesOrdenesTrabajoResponse(listadoReportesOrdenesTrabajo, null, code,
					mensaje, totalResultados));
		} catch (Exception ex) {
			System.out.println("Error al consultar por identificacion: " + ex.getMessage());
			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> aniosRepOrdenesTrabajoEstado(String regional, String unidad) {

		System.out.println("regional: " + regional);
		System.out.println("unidad: " + unidad);

		List<Anios> listadoReportesOrdenesTrabajo = new ArrayList<>();

		Long code = null;
		String mensaje = "";

		try {
			Query q = em.createNativeQuery(
					"SELECT ANIO FROM REP_ORDENES_TRABAJO_ESTADO WHERE REGIONAL = ? AND UNIDAD = ? GROUP BY ANIO ORDER BY ANIO");

			q.setParameter(1, regional);
			q.setParameter(2, unidad);

			listadoReportesOrdenesTrabajo = q.getResultList();

			if (listadoReportesOrdenesTrabajo.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado informacion";
			} else {
				code = 2L;
				mensaje = "No se ha encontrado información.";
				listadoReportesOrdenesTrabajo = new ArrayList<>();
			}

			Long totalResultados = (long) listadoReportesOrdenesTrabajo.size();

			return ResponseEntity.ok(new AniosResponse(listadoReportesOrdenesTrabajo, code, mensaje, totalResultados));
		} catch (Exception ex) {
			System.out.println("Error al consultar: " + ex.getMessage());
			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> mesesRepOrdenesTrabajoEstado(String regional, String unidad, Long anio) {

		System.out.println("regional: " + regional);
		System.out.println("unidad: " + unidad);
		System.out.println("anio: " + anio);

		List<MesesReporteOrdenesTrabajo> listadoReportesOrdenesTrabajo = new ArrayList<>();

		Long code = null;
		String mensaje = "";

		try {
			Query q = em.createNativeQuery(
					"SELECT MES, DECODE(MES, 1, 'ENERO', 2, 'FEBRERO', 3, 'MARZO', 4, 'ABRIL', 5, 'MAYO', 6, 'JUNIO', 7, 'JULIO', 8, 'AGOSTO', 9, 'SEPTIEMBRE', 10, 'OCTUBRE', 11, 'NOVIEMBRE', 12, 'DICIEMBRE') NOMBRE_MES \r\n"
							+ "FROM REP_ORDENES_TRABAJO_ESTADO WHERE REGIONAL = ? AND UNIDAD = ? AND ANIO = ? group by MES order by MES");

			q.setParameter(1, regional);
			q.setParameter(2, unidad);
			q.setParameter(3, anio);

			List<Object[]> lstItems = (List<Object[]>) q.getResultList();

			int i = 0;
			for (Object[] obj : lstItems) {
				MesesReporteOrdenesTrabajo mesesReporteOrdenesTrabajo = new MesesReporteOrdenesTrabajo();
				if (i < lstItems.size()) {
					mesesReporteOrdenesTrabajo.setMes(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
					mesesReporteOrdenesTrabajo.setNombreMes(obj[1] == null ? null : obj[1].toString());
				}
				listadoReportesOrdenesTrabajo.add(mesesReporteOrdenesTrabajo);
				i = i + 1;
			}

			if (listadoReportesOrdenesTrabajo.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado informacion";
			} else {
				code = 2L;
				mensaje = "No se ha encontrado información.";
				listadoReportesOrdenesTrabajo = new ArrayList<>();
			}

			Long totalResultados = (long) listadoReportesOrdenesTrabajo.size();

			return ResponseEntity.ok(new MesesReporteOrdenesTrabajoResponse(listadoReportesOrdenesTrabajo, code,
					mensaje, totalResultados));
		} catch (Exception ex) {
			System.out.println("Error al consultar: " + ex.getMessage());
			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> filtrosBusquedaRepOrdenesTrabajoEstado(String regional, String unidad, Long anio,
			Long mes) {
		List<Grafica1ReporteOrdenesTrabajo> listadoVwMaicOrdenSerj = new ArrayList<>();
		Query q = null;
		Long code = null;
		String mensaje = "";
		List<Object[]> lstItems = null;

		System.out.println("regional: " + regional);
		System.out.println("unidad: " + unidad);
		System.out.println("anio: " + anio);
		System.out.println("mes: " + mes);

		try {
			
			
			if (regional.isEmpty() && unidad.isEmpty() && anio == null && mes == null) {
				code = -1L;
				mensaje = "Debe digitar informacion en regional, unidad y año que son obligatorios.";
				listadoVwMaicOrdenSerj = new ArrayList<>();
				Long totalResultados = (long) listadoVwMaicOrdenSerj.size();
				return ResponseEntity.ok(new Grafica1ReporteOrdenesTrabajoResponse(listadoVwMaicOrdenSerj, code,
						mensaje, totalResultados));
			}

			if (regional != null && unidad != null && anio != null && mes == null) {

				q = em.createNativeQuery(
						"SELECT ESTADO_ORDEN, SUM(TOTAL) CANTIDAD FROM REP_ORDENES_TRABAJO_ESTADO where regional = ? and unidad = ? AND ANIO = ? GROUP BY ESTADO_ORDEN ORDER BY ESTADO_ORDEN");
				q.setParameter(1, regional);
				q.setParameter(2, unidad);
				q.setParameter(3, anio);

				lstItems = (List<Object[]>) q.getResultList();

				int i = 0;
				for (Object[] obj : lstItems) {
					Grafica1ReporteOrdenesTrabajo grafica1ReporteOrdenesTrabajo = new Grafica1ReporteOrdenesTrabajo();
					if (i < lstItems.size()) {
						grafica1ReporteOrdenesTrabajo.setEstadoOrden(obj[0] == null ? null : obj[0].toString());
						grafica1ReporteOrdenesTrabajo
								.setCantidad(Long.parseLong(obj[1] == null ? null : obj[1].toString()));
					}
					listadoVwMaicOrdenSerj.add(grafica1ReporteOrdenesTrabajo);
					i = i + 1;
				}
			}

			if (regional != null && unidad != null && anio != null && mes != null) {

				q = em.createNativeQuery(
						"SELECT ESTADO_ORDEN, SUM(TOTAL) CANTIDAD FROM REP_ORDENES_TRABAJO_ESTADO where regional = ? and unidad = ? AND ANIO = ? AND MES = ? GROUP BY ESTADO_ORDEN ORDER BY ESTADO_ORDEN");
				q.setParameter(1, regional);
				q.setParameter(2, unidad);
				q.setParameter(3, anio);
				q.setParameter(4, mes);

				lstItems = (List<Object[]>) q.getResultList();

				int i = 0;
				for (Object[] obj : lstItems) {
					Grafica1ReporteOrdenesTrabajo grafica1ReporteOrdenesTrabajo = new Grafica1ReporteOrdenesTrabajo();
					if (i < lstItems.size()) {
						grafica1ReporteOrdenesTrabajo.setEstadoOrden(obj[0] == null ? null : obj[0].toString());
						grafica1ReporteOrdenesTrabajo
								.setCantidad(Long.parseLong(obj[1] == null ? null : obj[1].toString()));
					}
					listadoVwMaicOrdenSerj.add(grafica1ReporteOrdenesTrabajo);
					i = i + 1;
				}
			}

			if (listadoVwMaicOrdenSerj.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado información.";
			} else {
				code = 2L;
				mensaje = "No se ha encontrado información.";
				listadoVwMaicOrdenSerj = new ArrayList<>();
			}
			Long totalResultados = (long) listadoVwMaicOrdenSerj.size();
			return ResponseEntity.ok(
					new Grafica1ReporteOrdenesTrabajoResponse(listadoVwMaicOrdenSerj, code, mensaje, totalResultados));
		} catch (Exception ex) {
			System.out.println("Error al consultar: " + ex.getMessage());
			return ResponseEntity.ok(ex.getMessage());
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> filtrosBusquedaDosRepOrdenesTrabajoEstado(String regional, String unidad, Long anio,
			Long mes) {
		List<Grafica1ReporteOrdenesTrabajo> listadoVwMaicOrdenSerj = new ArrayList<>();
		Query q = null;
		Long code = null;
		String mensaje = "";
		List<Object[]> lstItems = null;

		System.out.println("regional: " + regional);
		System.out.println("unidad: " + unidad);
		System.out.println("anio: " + anio);
		System.out.println("mes: " + mes);

		try {

			if (regional.isEmpty() && unidad.isEmpty() && anio == null && mes == null) {
				code = -1L;
				mensaje = "Debe digitar informacion en regional, unidad y año que son obligatorios.";
				listadoVwMaicOrdenSerj = new ArrayList<>();
				Long totalResultados = (long) listadoVwMaicOrdenSerj.size();
				return ResponseEntity.ok(new Grafica1ReporteOrdenesTrabajoResponse(listadoVwMaicOrdenSerj, code,
						mensaje, totalResultados));
			}

			if (regional != null && unidad != null && anio != null && mes == null) {

				q = em.createNativeQuery(
						"SELECT CLASE_ORDEN, SUM(TOTAL) CANTIDAD FROM REP_ORDENES_TRABAJO_ESTADO where regional = ? and unidad = ? AND ANIO = ? GROUP BY CLASE_ORDEN ORDER BY CLASE_ORDEN");
				q.setParameter(1, regional);
				q.setParameter(2, unidad);
				q.setParameter(3, anio);

				lstItems = (List<Object[]>) q.getResultList();

				int i = 0;
				for (Object[] obj : lstItems) {
					Grafica1ReporteOrdenesTrabajo grafica1ReporteOrdenesTrabajo = new Grafica1ReporteOrdenesTrabajo();
					if (i < lstItems.size()) {
						grafica1ReporteOrdenesTrabajo.setEstadoOrden(obj[0] == null ? null : obj[0].toString());
						grafica1ReporteOrdenesTrabajo
								.setCantidad(Long.parseLong(obj[1] == null ? null : obj[1].toString()));
					}
					listadoVwMaicOrdenSerj.add(grafica1ReporteOrdenesTrabajo);
					i = i + 1;
				}
			}

			if (regional != null && unidad != null && anio != null && mes != null) {

				q = em.createNativeQuery(
						"SELECT CLASE_ORDEN, SUM(TOTAL) CANTIDAD FROM REP_ORDENES_TRABAJO_ESTADO where regional = ? and unidad = ? AND ANIO = ? AND MES = ? GROUP BY CLASE_ORDEN ORDER BY CLASE_ORDEN");
				q.setParameter(1, regional);
				q.setParameter(2, unidad);
				q.setParameter(3, anio);
				q.setParameter(4, mes);

				lstItems = (List<Object[]>) q.getResultList();

				int i = 0;
				for (Object[] obj : lstItems) {
					Grafica1ReporteOrdenesTrabajo grafica1ReporteOrdenesTrabajo = new Grafica1ReporteOrdenesTrabajo();
					if (i < lstItems.size()) {
						grafica1ReporteOrdenesTrabajo.setEstadoOrden(obj[0] == null ? null : obj[0].toString());
						grafica1ReporteOrdenesTrabajo
								.setCantidad(Long.parseLong(obj[1] == null ? null : obj[1].toString()));
					}
					listadoVwMaicOrdenSerj.add(grafica1ReporteOrdenesTrabajo);
					i = i + 1;
				}
			}

			if (listadoVwMaicOrdenSerj.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado información.";
			} else {
				code = 2L;
				mensaje = "No se ha encontrado información.";
				listadoVwMaicOrdenSerj = new ArrayList<>();
			}
			Long totalResultados = (long) listadoVwMaicOrdenSerj.size();
			return ResponseEntity.ok(
					new Grafica1ReporteOrdenesTrabajoResponse(listadoVwMaicOrdenSerj, code, mensaje, totalResultados));
		} catch (Exception ex) {
			System.out.println("Error al consultar: " + ex.getMessage());
			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> filtrosBusquedaTresRepOrdenesTrabajoEstado(String regional, String unidad, Long anio,
			Long mes) {
		List<Grafica3ReporteOrdenesTrabajo> listadoVwMaicOrdenSerj = new ArrayList<>();
		Query q = null;
		Long code = null;
		String mensaje = "";
		List<Object[]> lstItems = null;

		System.out.println("regional: " + regional);
		System.out.println("unidad: " + unidad);
		System.out.println("anio: " + anio);
		System.out.println("mes: " + mes);

		try {

			if (regional.isEmpty() && unidad.isEmpty() && anio == null && mes == null) {
				code = -1L;
				mensaje = "Debe digitar informacion en regional, unidad y año que son obligatorios.";
				listadoVwMaicOrdenSerj = new ArrayList<>();
				Long totalResultados = (long) listadoVwMaicOrdenSerj.size();
				return ResponseEntity.ok(new Grafica3ReporteOrdenesTrabajoResponse(listadoVwMaicOrdenSerj, code,
						mensaje, totalResultados));
			}

			if (regional != null && unidad != null && anio != null && mes == null) {

				q = em.createNativeQuery(
						"SELECT MES, DECODE(MES, 1, 'ENERO', 2, 'FEBRERO', 3, 'MARZO', 4, 'ABRIL', 5, 'MAYO', 6, 'JUNIO', 7, 'JULIO', 8, 'AGOSTO', 9, 'SEPTIEMBRE', 10, 'OCTUBRE', 11, 'NOVIEMBRE', 12, 'DICIEMBRE') NOMBRE_MES, TOTAL_OT, TOTAL_AC, PROMEDIO, CALIFICACION FROM REP_ORDENES_TRABAJO_ACTIVIDADES WHERE REGIONAL = ? AND UNIDAD = ? AND ANIO = ? ORDER BY MES");
				q.setParameter(1, regional);
				q.setParameter(2, unidad);
				q.setParameter(3, anio);

				lstItems = (List<Object[]>) q.getResultList();

				int i = 0;
				for (Object[] obj : lstItems) {
					Grafica3ReporteOrdenesTrabajo grafica3ReporteOrdenesTrabajo = new Grafica3ReporteOrdenesTrabajo();
					if (i < lstItems.size()) {
						//System.out.println("obj[5]: " + obj[5].getClass().getSimpleName());
						
						String definicionCalificacion = "";
						String color = "";
						String codigoColorHexa = "";
						String codigoColorRgba = "";
						
						BigDecimal bd = new BigDecimal(obj[5].toString());  
						String calificacionString = bd.toString();  
						
						long calificacionLong = Long.parseLong(calificacionString);  
						
						if (calificacionLong >= 0 && calificacionLong <= 69) {
							definicionCalificacion = "Deficiente";
							color = "Rojo";
							codigoColorHexa = "E74C3C";
							codigoColorRgba = "rgba(231,76,60)";
						}
						
						if (calificacionLong >= 70 && calificacionLong <= 89) {
							definicionCalificacion = "Basico";
							color = "Amarillo";
							codigoColorHexa = "F1C40F";
							codigoColorRgba = "rgba(241,196,15)";
						}
						
						if (calificacionLong >= 90 && calificacionLong <= 100) {
							definicionCalificacion = "Satisfactorio";
							color = "Verde";
							codigoColorHexa = "229954";
							codigoColorRgba = "rgba(34,153,84)";
						}					
		
						grafica3ReporteOrdenesTrabajo.setMes(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
						grafica3ReporteOrdenesTrabajo.setNombreMes(obj[1] == null ? null : obj[1].toString());
						grafica3ReporteOrdenesTrabajo.setTotalOrdenesTrabajo(Long.parseLong(obj[2] == null ? null : obj[2].toString()));
						grafica3ReporteOrdenesTrabajo.setTotalActividades(Long.parseLong(obj[3] == null ? null : obj[3].toString()));
						grafica3ReporteOrdenesTrabajo.setPromedio(Float.valueOf(obj[4] == null ? null : obj[4].toString()));
						grafica3ReporteOrdenesTrabajo.setCalificacion(Long.parseLong(obj[5] == null ? null : obj[5].toString()));
						grafica3ReporteOrdenesTrabajo.setPuntuacion(definicionCalificacion);
						grafica3ReporteOrdenesTrabajo.setColor(color);
						grafica3ReporteOrdenesTrabajo.setCodigoColorHexa(codigoColorHexa);
						grafica3ReporteOrdenesTrabajo.setCodigoColorRgba(codigoColorRgba);
					}
					listadoVwMaicOrdenSerj.add(grafica3ReporteOrdenesTrabajo);
					i = i + 1;
				}
			}

			if (regional != null && unidad != null && anio != null && mes != null) {

				q = em.createNativeQuery(
						"SELECT MES, DECODE(MES, 1, 'ENERO', 2, 'FEBRERO', 3, 'MARZO', 4, 'ABRIL', 5, 'MAYO', 6, 'JUNIO', 7, 'JULIO', 8, 'AGOSTO', 9, 'SEPTIEMBRE', 10, 'OCTUBRE', 11, 'NOVIEMBRE', 12, 'DICIEMBRE') NOMBRE_MES, TOTAL_OT, TOTAL_AC, PROMEDIO, CALIFICACION FROM REP_ORDENES_TRABAJO_ACTIVIDADES WHERE REGIONAL = ? AND UNIDAD = ? AND ANIO = ? AND MES = ? ORDER BY MES");
				q.setParameter(1, regional);
				q.setParameter(2, unidad);
				q.setParameter(3, anio);
				q.setParameter(4, mes);

				lstItems = (List<Object[]>) q.getResultList();

				int i = 0;
				for (Object[] obj : lstItems) {
					Grafica3ReporteOrdenesTrabajo grafica3ReporteOrdenesTrabajo = new Grafica3ReporteOrdenesTrabajo();
					if (i < lstItems.size()) {
						String definicionCalificacion = "";
						String color = "";
						String codigoColorHexa = "";
						String codigoColorRgba = "";
						
						BigDecimal bd = new BigDecimal(obj[5].toString());  
						String calificacionString = bd.toString();  
						
						long calificacionLong = Long.parseLong(calificacionString);  
						
						if (calificacionLong >= 0 && calificacionLong <= 69) {
							definicionCalificacion = "Deficiente";
							color = "Rojo";
							codigoColorHexa = "E74C3C";
							codigoColorRgba = "rgba(231,76,60)";
						}
						
						if (calificacionLong >= 70 && calificacionLong <= 89) {
							definicionCalificacion = "Basico";
							color = "Amarillo";
							codigoColorHexa = "F1C40F";
							codigoColorRgba = "rgba(241,196,15)";
						}
						
						if (calificacionLong >= 90 && calificacionLong <= 100) {
							definicionCalificacion = "Satisfactorio";
							color = "Verde";
							codigoColorHexa = "229954";
							codigoColorRgba = "rgba(34,153,84)";
						}					
		
						grafica3ReporteOrdenesTrabajo.setMes(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
						grafica3ReporteOrdenesTrabajo.setNombreMes(obj[1] == null ? null : obj[1].toString());
						grafica3ReporteOrdenesTrabajo.setTotalOrdenesTrabajo(Long.parseLong(obj[2] == null ? null : obj[2].toString()));
						grafica3ReporteOrdenesTrabajo.setTotalActividades(Long.parseLong(obj[3] == null ? null : obj[3].toString()));
						grafica3ReporteOrdenesTrabajo.setPromedio(Float.valueOf(obj[4] == null ? null : obj[4].toString()));
						grafica3ReporteOrdenesTrabajo.setCalificacion(Long.parseLong(obj[5] == null ? null : obj[5].toString()));
						grafica3ReporteOrdenesTrabajo.setPuntuacion(definicionCalificacion);
						grafica3ReporteOrdenesTrabajo.setColor(color);
						grafica3ReporteOrdenesTrabajo.setCodigoColorHexa(codigoColorHexa);
						grafica3ReporteOrdenesTrabajo.setCodigoColorRgba(codigoColorRgba);
					}
					listadoVwMaicOrdenSerj.add(grafica3ReporteOrdenesTrabajo);
					i = i + 1;
				}
			}

			if (listadoVwMaicOrdenSerj.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado información.";
			} else {
				code = 2L;
				mensaje = "No se ha encontrado información.";
				listadoVwMaicOrdenSerj = new ArrayList<>();
			}
			Long totalResultados = (long) listadoVwMaicOrdenSerj.size();
			return ResponseEntity.ok(
					new Grafica3ReporteOrdenesTrabajoResponse(listadoVwMaicOrdenSerj, code, mensaje, totalResultados));
		} catch (Exception ex) {
			System.out.println("Error al consultar: " + ex.getMessage());
			return ResponseEntity.ok(ex.getMessage());
		}
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
    @Override
    @Transactional
    public VwPwaAdminUsuariosNacional buscarUsuarioNacionalByUsuario(String usuarioEmpresarial) {
        List<VwPwaAdminUsuariosNacional> listadoVwPwaAdminUsuariosNacional = new ArrayList<>();
        VwPwaAdminUsuariosNacional vwPwaAdminUsuariosNacional = null;
        Long code = null;
        String mensaje = " ";

        Query q = em.createNativeQuery("select * from VW_PWA_ADMIN_USUARIOS_NACIONAL WHERE usuario_sipac = ?",
        		VwPwaAdminUsuariosNacional.class);
        q.setParameter(1, usuarioEmpresarial);

        listadoVwPwaAdminUsuariosNacional = q.getResultList();
        System.out.println("USUARIO: " + listadoVwPwaAdminUsuariosNacional);
        System.out.println("Tamaño de la lista: " + listadoVwPwaAdminUsuariosNacional.size());

        if (listadoVwPwaAdminUsuariosNacional.size() > 0) {
            code = 0L;
            vwPwaAdminUsuariosNacional = listadoVwPwaAdminUsuariosNacional.get(0);
            mensaje = "Se ha encontrado el usuario";
        } else {
            code = 2L;
            mensaje = "No se ha encontrado el usuario";
        }
        return vwPwaAdminUsuariosNacional;
    }
	
	@SuppressWarnings({ "unchecked", "unused" })
    @Override
    @Transactional
    public VwPwaAdminUsuariosNacional buscarUsuarioNacionalByRegional(String regional) {
        List<VwPwaAdminUsuariosNacional> listadoVwPwaAdminUsuariosNacional = new ArrayList<>();
        VwPwaAdminUsuariosNacional vwPwaAdminUsuariosNacional = null;
        Long code = null;
        String mensaje = " ";

        Query q = em.createNativeQuery("select * from VW_PWA_ADMIN_USUARIOS_NACIONAL WHERE REGIONAL = ?",
        		VwPwaAdminUsuariosNacional.class);
        q.setParameter(1, regional);

        listadoVwPwaAdminUsuariosNacional = q.getResultList();
        System.out.println("USUARIO: " + listadoVwPwaAdminUsuariosNacional);
        System.out.println("Tamaño de la lista: " + listadoVwPwaAdminUsuariosNacional.size());

        if (listadoVwPwaAdminUsuariosNacional.size() > 0) {
            code = 0L;
            vwPwaAdminUsuariosNacional = listadoVwPwaAdminUsuariosNacional.get(0);
            mensaje = "Se ha encontrado el usuario";
        } else {
            code = 2L;
            mensaje = "No se ha encontrado el usuario";
            System.out.println("Entro al elseeeee a buscar el usuario");
        }
        return vwPwaAdminUsuariosNacional;
    }
	
	@SuppressWarnings({ "unchecked", "unused" })
    @Override
    @Transactional
    public VwPwaAdminUsuariosNacional buscarUsuarioNacionalByUndeCodigoSipac(Long undeCodigoSipac) {
        List<VwPwaAdminUsuariosNacional> listadoVwPwaAdminUsuariosNacional = new ArrayList<>();
        VwPwaAdminUsuariosNacional vwPwaAdminUsuariosNacional = null;
        Long code = null;
        String mensaje = " ";
        Long cantidadRegistros = null;

        Query q = em.createNativeQuery("select * from VW_PWA_ADMIN_USUARIOS_NACIONAL WHERE UNDE_CODIGO_SIPAC = ?",
        		VwPwaAdminUsuariosNacional.class);
        q.setParameter(1, undeCodigoSipac);

        listadoVwPwaAdminUsuariosNacional = q.getResultList();

        System.out.println("Tamaño de la lista: " + listadoVwPwaAdminUsuariosNacional.size());

        if (listadoVwPwaAdminUsuariosNacional.size() > 0) {
            code = 0L;
            vwPwaAdminUsuariosNacional = listadoVwPwaAdminUsuariosNacional.get(0);
            mensaje = "Se ha encontrado el usuario";
            cantidadRegistros = (long) listadoVwPwaAdminUsuariosNacional.size();
        } else {
            code = 2L;
            mensaje = "No se ha encontrado el usuario";
            System.out.println("Entro al elseeeee a buscar el usuario");
            cantidadRegistros = (long) listadoVwPwaAdminUsuariosNacional.size();
        }
        return vwPwaAdminUsuariosNacional;
    }

}
