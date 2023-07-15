package co.gov.policia.pwa.modal.services.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.gov.policia.pwa.entity.DiaTipoActividades;
import co.gov.policia.pwa.modal.entity.AmbitoDiaDiaLista;
import co.gov.policia.pwa.modal.service.AmbitoDiaDiaListaService;
import co.gov.policia.pwa.payload.response.DiaTipoActividadesResponse;
import co.gov.policia.pwa.service.impl.AbstractService;

@Service
public class AmbitoDiaDiaListaImpl extends AbstractService implements AmbitoDiaDiaListaService {

	private static final long serialVersionUID = 1L;

	@Lazy
	@Autowired
	AmbitoDiaDiaListaService ambitoDiaDiaListaService;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<AmbitoDiaDiaLista> selectAllAmbitoDiaDiaLista() {
		List<AmbitoDiaDiaLista> listadoAmbitoDiaDiaLista = new ArrayList<>();

		try {
			Query q = em.createNativeQuery(
					"select * from dia_empleados_funcionalidades where tipo_variable = 'AMBITO' AND ESTADO = 'AC' ORDER BY descripcion");

			List<Object[]> lstItems = (List<Object[]>) q.getResultList();

			int i = 0;
			for (Object[] obj : lstItems) {
				AmbitoDiaDiaLista ambitoDiaDiaLista = new AmbitoDiaDiaLista();
				if (i < lstItems.size()) {
					ambitoDiaDiaLista.setConsecutivo(obj[0] == null ? null : obj[0].toString());
					ambitoDiaDiaLista.setDescripcion(obj[1] == null ? null : obj[1].toString());
					ambitoDiaDiaLista.setEstado(obj[2] == null ? null : obj[2].toString());
					ambitoDiaDiaLista.setTipoVariable(obj[3] == null ? null : obj[3].toString());
				}
				listadoAmbitoDiaDiaLista.add(ambitoDiaDiaLista);
				i = i + 1;
			}
		} catch (Exception ex) {

		}
		return listadoAmbitoDiaDiaLista;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public List<AmbitoDiaDiaLista> actividadRealizadaByConsucutivo(String consecutivo) {
		System.out.println("consecutivo: " + consecutivo);
		List<AmbitoDiaDiaLista> listadoAmbitoDiaDiaLista = new ArrayList<>();

		try {
			List<Object[]> lstItems = null;

			if (consecutivo.equals("OP") || consecutivo.equals("AD")) {
				Query q = em.createNativeQuery("SELECT * FROM  DIA_EMPLEADOS_FUNCIONALIDADES\r\n"
						+ "WHERE CONSECUTIVO IN ('1','2','3','4','5','6','7','8'\r\n"
						+ ",'9','10','11','12','13','14','15','16','17','18','19','20','21','22'\r\n"
						+ ",'23','24','25','26','27','28','44','45','46','47','48') AND ESTADO = 'AC' ORDER BY descripcion");
				lstItems = (List<Object[]>) q.getResultList();
			}

			if (consecutivo.equals("AC")) {
				Query q = em.createNativeQuery("SELECT * FROM  DIA_EMPLEADOS_FUNCIONALIDADES\r\n"
						+ "WHERE CONSECUTIVO IN ('8','9','10','29','30','31','32','33','34','35','36'\r\n"
						+ ",'37','38','39','40','41','42','43','44') AND ESTADO = 'AC' ORDER BY descripcion");
				lstItems = (List<Object[]>) q.getResultList();
			}

			int i = 0;

			for (Object[] obj : lstItems) {
				AmbitoDiaDiaLista ambitoDiaDiaLista = new AmbitoDiaDiaLista();
				if (i < lstItems.size()) {
					ambitoDiaDiaLista.setConsecutivo(obj[0] == null ? null : obj[0].toString());
					ambitoDiaDiaLista.setDescripcion(obj[1] == null ? null : obj[1].toString());
					ambitoDiaDiaLista.setEstado(obj[2] == null ? null : obj[2].toString());
					ambitoDiaDiaLista.setTipoVariable(obj[3] == null ? null : obj[3].toString());
				}
				listadoAmbitoDiaDiaLista.add(ambitoDiaDiaLista);
				i = i + 1;
			}
		} catch (Exception ex) {

		}
		return listadoAmbitoDiaDiaLista;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional
	public ResponseEntity<?> descripcionActividadRealizadaByConsucutivo(String consecutivo) {
		List<DiaTipoActividades> listadoDiaTipoActividades = new ArrayList<>();
		List<DiaTipoActividades> diaTipoActividades = null;
		Long code = null;
		String mensaje = "";

		Query q = null;

		try {

			q = em.createNativeQuery("select * from DIA_TIPO_ACTIVIDADES WHERE tipo_variable = ?",
					DiaTipoActividades.class);

			q.setParameter(1, consecutivo);

			listadoDiaTipoActividades = q.getResultList();

			if (listadoDiaTipoActividades.size() > 0) {
				code = 0L;
				diaTipoActividades = listadoDiaTipoActividades;
				mensaje = "Se ha encontrado informacion";

			} else {
				code = 2L;
				mensaje = "No se ha encontrado información.";
				diaTipoActividades = listadoDiaTipoActividades;
			}

			Long totalResultados = (long) listadoDiaTipoActividades.size();

			return ResponseEntity.ok(new DiaTipoActividadesResponse(diaTipoActividades, code, mensaje, totalResultados));
		} catch (Exception ex) {

			return ResponseEntity.ok(ex.getMessage());
		}
	}

}
