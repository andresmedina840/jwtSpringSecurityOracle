package co.gov.policia.pwa.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.payload.response.VwPwaControlParqueaderoResponse;
import co.gov.policia.pwa.entity.VwPwaControlParqueadero;
import co.gov.policia.pwa.entity.VwPwaFotosParqueadero;
import co.gov.policia.pwa.modal.entity.VwPwaControlParqueaderoLista;
import co.gov.policia.pwa.modal.payload.response.VwPwaControlParqueaderoListaResponse;
import co.gov.policia.pwa.service.VwPwaControlParqueaderoService;

@Service
public class VwPwaControlParqueaderoImpl extends AbstractService implements VwPwaControlParqueaderoService {

	private static final long serialVersionUID = 1L;

	@Lazy
	@Autowired
	VwPwaControlParqueaderoService VwPwaControlParqueaderoService;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public ResponseEntity<?> selectVwPwaControlParqueaderoByPlaca(String PlacaVehiculo) {
		List<VwPwaControlParqueadero> listadoVwPwaControlParqueadero = new ArrayList<>();
		List<VwPwaControlParqueadero> VwPwaControlParqueadero = null;

		Long code = null;
		String mensaje = "";

		try {
			Query q = em.createNativeQuery("SELECT * FROM vw_pwa_control_parqueadero WHERE PLACA_VEHICULO = :codigo ",
					VwPwaControlParqueadero.class);

			q.setParameter("codigo", PlacaVehiculo);

			listadoVwPwaControlParqueadero = q.getResultList();

			if (listadoVwPwaControlParqueadero.size() > 0) {
				code = 0L;
				VwPwaControlParqueadero = listadoVwPwaControlParqueadero;
				mensaje = "Se ha encontrado informacion";
			} else {
				code = 2L;
				mensaje = "No se ha encontrado información.";
				listadoVwPwaControlParqueadero = new ArrayList<>();
			}

			Long totalResultados = (long) listadoVwPwaControlParqueadero.size();

			return ResponseEntity
					.ok(new VwPwaControlParqueaderoResponse(VwPwaControlParqueadero, code, mensaje, totalResultados));
		} catch (Exception ex) {

			return ResponseEntity.ok(ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public ResponseEntity<?> selectVwPwaControlParqueaderoByPlaca1(String PlacaVehiculo) {
		List<VwPwaControlParqueaderoLista> listadoVwPwaControlParqueaderoLista = new ArrayList<>();
		// List<VwPwaControlParqueaderoLista> vwPwaControlParqueaderoLista = null;

		Long code = null;
		String mensaje = "";
		String estadoSoat = "";
		String estadoTecnomecanica = "";

		try {
			Query q = em.createNativeQuery("SELECT * FROM VW_PWA_CONTROL_PARQUEADERO WHERE PLACA_VEHICULO = :codigo ");

			q.setParameter("codigo", PlacaVehiculo);

			List<Object[]> lstItems = (List<Object[]>) q.getResultList();

			int i = 0;
			for (Object[] obj : lstItems) {
				VwPwaControlParqueaderoLista vwPwaControlParqueaderoLista = new VwPwaControlParqueaderoLista();
				if (i < lstItems.size()) {				
					
					String fechaMatricula = obj[9].toString();
					String fechaMatriculaRecortada = fechaMatricula.substring(0, 10);

					String fechaVecimientoSoat = obj[10].toString();
					String fechaVecimientoSoatRecortada = fechaVecimientoSoat.substring(0, 10);

					String fechaVecimientoTecnomecanica = obj[11].toString();
					String fechaVecimientoTecnomecanicaRecortada = fechaVecimientoTecnomecanica.substring(0, 10);

					SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", new Locale("es", "CO"));
					inputFormat.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));

					SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "CO"));
					outputFormat.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));
					
					Date fechaMatriculaDate = inputFormat.parse(fechaMatriculaRecortada);
					String fechaMatriculaFormateada = outputFormat.format(fechaMatriculaDate);

					Date fechaVecimientoSoatDate = inputFormat.parse(fechaVecimientoSoatRecortada);
					String fechaVecimientoSoatDateFormateada = outputFormat.format(fechaVecimientoSoatDate);

					Date fechaVecimientoTecnomecanicaDate = inputFormat.parse(fechaVecimientoTecnomecanicaRecortada);
					String fechaVecimientoTecnomecanicaFormateada = outputFormat.format(fechaVecimientoTecnomecanicaDate);

					Long diasVencimientoSoat = (Long) ((fechaVecimientoSoatDate.getTime() - new Date().getTime() + (1000 * 60 * 60 * 24)) / 86400000);
					
					Long diasVencimientoTecnomecanica = (Long) ((fechaVecimientoTecnomecanicaDate.getTime() - new Date().getTime() + (1000 * 60 * 60 * 24)) / 86400000);

					if (diasVencimientoSoat >= 0) {
						estadoSoat = "VIGENTE";
					} else {
						estadoSoat = "VENCIDO";
					}
					
					if (diasVencimientoTecnomecanica >= 0) {
						estadoTecnomecanica = "VIGENTE";
					} else {
						estadoTecnomecanica = "VENCIDO";
					}

					vwPwaControlParqueaderoLista.setConsecutivo(Long.parseLong(obj[0] == null ? null : obj[0].toString()));
					vwPwaControlParqueaderoLista.setClaseAutomotor(obj[1] == null ? null : obj[1].toString());
					vwPwaControlParqueaderoLista.setUndeCodigo(Long.parseLong(obj[2] == null ? null : obj[2].toString()));
					vwPwaControlParqueaderoLista.setUnidadFuncionario(obj[3] == null ? null : obj[3].toString());
					vwPwaControlParqueaderoLista.setFuncionarioResponsable(obj[4] == null ? null : obj[4].toString());
					vwPwaControlParqueaderoLista.setPropietario(obj[5] == null ? null : obj[5].toString());
					vwPwaControlParqueaderoLista.setNumeroCelular(Long.parseLong(obj[6] == null ? null : obj[6].toString()));
					vwPwaControlParqueaderoLista.setPlacaVehiculo(obj[7] == null ? null : obj[7].toString());
					vwPwaControlParqueaderoLista.setCilidraje(obj[8] == null ? null : obj[8].toString());
					vwPwaControlParqueaderoLista.setFechaMatricula(fechaMatriculaFormateada == null ? null : fechaMatriculaFormateada);
					vwPwaControlParqueaderoLista.setFechaVenSoat(fechaVecimientoSoatDateFormateada == null ? null : fechaVecimientoSoatDateFormateada);
					vwPwaControlParqueaderoLista.setFechaVenTecMec(fechaVecimientoTecnomecanicaFormateada == null ? null : fechaVecimientoTecnomecanicaFormateada);
					vwPwaControlParqueaderoLista.setCupoSigic(Long.parseLong(obj[12] == null ? null : obj[12].toString()));
					vwPwaControlParqueaderoLista.setEstadoPermiso(obj[13] == null ? null : obj[13].toString());
					vwPwaControlParqueaderoLista.setDiasVencimientoSoat(diasVencimientoSoat == null ? null : diasVencimientoSoat);
					vwPwaControlParqueaderoLista.setEstadoSoat(estadoSoat == null ? null : estadoSoat);
					vwPwaControlParqueaderoLista.setDiasVencimientoTecnoMecanica(diasVencimientoTecnomecanica == null ? null : diasVencimientoTecnomecanica);
					vwPwaControlParqueaderoLista.setEstadoTecnomecanica(estadoTecnomecanica == null ? null : estadoTecnomecanica);
				}
				listadoVwPwaControlParqueaderoLista.add(vwPwaControlParqueaderoLista);
				i = i + 1;
			}

			if (listadoVwPwaControlParqueaderoLista.size() > 0) {
				code = 0L;
				mensaje = "Se ha encontrado informacion, " + "SOAT: " + estadoSoat + ", TECNOMECANICA: " + estadoTecnomecanica;
			} else {
				code = 2L;
				mensaje = "No se ha encontrado información.";
				listadoVwPwaControlParqueaderoLista = new ArrayList<>();
			}

			Long totalResultados = (long) listadoVwPwaControlParqueaderoLista.size();

			return ResponseEntity.ok(new VwPwaControlParqueaderoListaResponse(listadoVwPwaControlParqueaderoLista, code,
					mensaje, totalResultados));
		} catch (Exception ex) {

			return ResponseEntity.ok(ex.getMessage());
		}
	}
	
	@Override
    @Transactional
    public VwPwaFotosParqueadero obtenerNombreImagenParqueadero(Long consecutivo) {
        List<VwPwaFotosParqueadero> lstVwPwaFotosParqueadero = new ArrayList<>();
        VwPwaFotosParqueadero vwPwaFotosParqueadero = null;
        try {

            //long codigoLaboratorioLong = Long.valueOf(codigoLaboratorio);

            TypedQuery<VwPwaFotosParqueadero> q = em.createQuery(
                    "SELECT u FROM VwPwaFotosParqueadero u where u.consecutivo=:consecutivo",
                    VwPwaFotosParqueadero.class);

            q.setParameter("consecutivo", consecutivo);

            lstVwPwaFotosParqueadero = q.getResultList();
            if (lstVwPwaFotosParqueadero.size() > 0) {
            	vwPwaFotosParqueadero = lstVwPwaFotosParqueadero.get(0);
            } else {
            	vwPwaFotosParqueadero = new VwPwaFotosParqueadero();
            }

        } catch (Exception ex) {
            System.err.println("Error al buscar la ruta del FileSystem: " + ex.getMessage());
            lstVwPwaFotosParqueadero = new ArrayList<>();
        }
        return vwPwaFotosParqueadero;
    }
	
	@Override
    @Transactional
    public VwPwaFotosParqueadero obtenerNombreFotosParqueadero(Long docDocumentosId) {
        List<VwPwaFotosParqueadero> lstVwPwaFotosParqueadero = new ArrayList<>();
        VwPwaFotosParqueadero vwPwaFotosParqueadero = null;
        try {

            TypedQuery<VwPwaFotosParqueadero> q = em.createQuery(
                    "SELECT u FROM VwPwaFotosParqueadero u where u.docDocumentosId=:docDocumentosId",
                    VwPwaFotosParqueadero.class);

            q.setParameter("docDocumentosId", docDocumentosId);

            lstVwPwaFotosParqueadero = q.getResultList();
            if (lstVwPwaFotosParqueadero.size() > 0) {
            	vwPwaFotosParqueadero = lstVwPwaFotosParqueadero.get(0);
            } else {
            	vwPwaFotosParqueadero = new VwPwaFotosParqueadero();
            }

        } catch (Exception ex) {
            System.err.println("Error al buscar la ruta del FileSystem: " + ex.getMessage());
            lstVwPwaFotosParqueadero = new ArrayList<>();
        }
        return vwPwaFotosParqueadero;
    }

}
