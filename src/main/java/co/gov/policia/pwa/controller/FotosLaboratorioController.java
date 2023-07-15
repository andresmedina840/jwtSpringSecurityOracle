package co.gov.policia.pwa.controller;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import org.apache.commons.io.FilenameUtils;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import co.gov.policia.pwa.entity.AdmDisciplinasJecri;
import co.gov.policia.pwa.entity.PwaProcedimientosJecri;
import co.gov.policia.pwa.service.FotosLaboratorioService;
import co.gov.policia.pwa.util.MediaTypeUtils;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/fotoslaboratorios")
public class FotosLaboratorioController {

	@Autowired
	FotosLaboratorioService fotosLaboratorioService;

	@Autowired
	private ServletContext servletContext;

	/*****************************************************
	 * Vista previa del archivo fotos disciplinas
	 *****************************************************/
	@SuppressWarnings({ "unused" })
	@GetMapping(value = "/previewFotoLaboratorio", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public void previewFotoLaboratorio(@RequestParam Long codigoLaboratorio, HttpServletRequest request,
			HttpServletResponse response) {

		AdmDisciplinasJecri nombreArchivoGardar = fotosLaboratorioService.getNombreDeArchivo(codigoLaboratorio);
		String rutaGuardadoImagenFoto = nombreArchivoGardar.getRutaArchivoImagen();
		String nombreImagenFoto = nombreArchivoGardar.getNombreImagen();

		ByteArrayResource resource = null;
		byte[] byteReport = null;
		File file = null;
		Path path = null;

		String filename = nombreImagenFoto.toString().trim();

		MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, filename);

		try {
			String filePath = FilenameUtils.normalize(rutaGuardadoImagenFoto);
			file = new File(filePath);
			path = (Path) Paths.get(file.getAbsolutePath());
			resource = new ByteArrayResource(Files.readAllBytes((java.nio.file.Path) path));

		} catch (Exception e) {
			System.err.println("Excepcion descargando el archivo: " + e.getMessage());
		}

		if (file.exists()) {
			byte[] data = null;
			try {
				FileInputStream input = new FileInputStream(file);
				data = new byte[input.available()];
				input.read(data);
				response.getOutputStream().write(data);
				input.close();
			} catch (Exception e) {
				System.err.println("excepción de procesamiento de imagen:" + e.getMessage());
			}
		} else {
			return;
		}
	}

	/*****************************************************
	 * Vista previa del archivo icono disciplinas
	 *****************************************************/
	@SuppressWarnings({ "unused" })
	@GetMapping(value = "/previewIconoLaboratorio", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public void previewIconoLaboratorio(@RequestParam Long codigoLaboratorio, HttpServletRequest request, HttpServletResponse response) {

		AdmDisciplinasJecri nombreArchivoGardar = fotosLaboratorioService.getNombreDeArchivo(codigoLaboratorio);
		String rutaGuardado = nombreArchivoGardar.getRutaNombreIcono();
		String nombreArchivoGuardado = nombreArchivoGardar.getNombreIcono();

		ByteArrayResource resource = null;
		byte[] byteReport = null;
		File file = null;
		Path path = null;

		String filename = nombreArchivoGuardado.toString().trim();

		MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, filename);

		try {
			String filePath = FilenameUtils.normalize(rutaGuardado);
			file = new File(filePath);
			path = (Path) Paths.get(file.getAbsolutePath());
			resource = new ByteArrayResource(Files.readAllBytes((java.nio.file.Path) path));

		} catch (Exception e) {
			System.err.println("Excepcion descargando el archivo: " + e.getMessage());
		}

		if (file.exists()) {
			byte[] data = null;
			try {
				FileInputStream input = new FileInputStream(file);
				data = new byte[input.available()];
				input.read(data);
				response.getOutputStream().write(data);
				input.close();
			} catch (Exception e) {
				System.err.println("excepción de procesamiento de archivos:" + e.getMessage());
			}
		} else {
			return;
		}
	}

	// La siguiente funcion elimina los acentos de las letras
	public static String cleanString(String texto) {
		texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
		texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		return texto;
	}

	/*****************************************
	 * Descargar archivos PDF
	 *****************************************/
	@GetMapping(value = "/downloadArchivosPDFProce", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<ByteArrayResource> descargarPDFProcedimientos(@RequestParam Long consecutivo,
			Long idDisciplina) {

		String rutaGuardado = null;

		PwaProcedimientosJecri obtieneNombreProce = fotosLaboratorioService.getNombreProdeci(consecutivo, idDisciplina);

		if (obtieneNombreProce.getRutaArchivo().equals("")) {
			ResponseEntity.ok().body(null);
		} else {
			rutaGuardado = obtieneNombreProce.getRutaArchivo();
		}

		// String nombreArchivoProcedimiento = obtieneNombreProce.getNombreProcedimiento();
		String nombrePDFProcedimiento = obtieneNombreProce.getNombreArchivo();

		ByteArrayResource resource = null;

		File file = null;
		Path path = null;

		String filename = nombrePDFProcedimiento;

		MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, filename);

		try {
			String filePath = FilenameUtils.normalize(rutaGuardado);
			file = new File(filePath);

			path = (Path) Paths.get(file.getAbsolutePath());

			resource = new ByteArrayResource(Files.readAllBytes((java.nio.file.Path) path));

		} catch (Exception e) {

		}
		return ResponseEntity.ok()
				// Content-Disposition
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
				// Content-Type
				.contentType(MediaType.parseMediaType(mediaType.toString()))
				// Content-Lengh
				.contentLength(file.length()).body(resource);
	}

}
