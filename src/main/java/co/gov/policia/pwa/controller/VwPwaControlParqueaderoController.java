package co.gov.policia.pwa.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.io.FilenameUtils;
import java.io.FileInputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.gov.policia.pwa.entity.VwPwaFotosParqueadero;
import co.gov.policia.pwa.service.VwPwaControlParqueaderoService;
import co.gov.policia.pwa.util.MediaTypeUtils;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/api/VwPwaControlParqueadero")
public class VwPwaControlParqueaderoController {
	
    @Autowired
    VwPwaControlParqueaderoService vwPwaControlParqueaderoService;
    
    @Autowired
    private ServletContext servletContext;
    
    @GetMapping(value = "/selectVwPwaControlParqueaderoByPlaca", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> selectVwPwaControlParqueaderoByPlaca(@RequestParam String PlacaVehiculo) {
        return vwPwaControlParqueaderoService.selectVwPwaControlParqueaderoByPlaca1(PlacaVehiculo);
    }
    
    /*****************************************************
     * Vista foto parqueadero
     *****************************************************/
    @SuppressWarnings({ "unused" })
    @GetMapping(value = "/verFotoParqueadero", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public void verFotoParqueadero(@RequestParam Long consecutivo, HttpServletRequest request,
            HttpServletResponse response) {

    	VwPwaFotosParqueadero nombreArchivoGardar = vwPwaControlParqueaderoService.obtenerNombreImagenParqueadero(consecutivo); 
    	
    	Long docDocumentosId = nombreArchivoGardar.getDocDocumentosId();
    	System.out.println("docDocumentosId: " + docDocumentosId);
    	
    	VwPwaFotosParqueadero nombreFotosParqueadero = vwPwaControlParqueaderoService.obtenerNombreFotosParqueadero(docDocumentosId);
        String rutaGuardadoImagenFoto = nombreFotosParqueadero.getRuta();
        String nombreImagenFoto = nombreFotosParqueadero.getNombre();
        
        String rutaCompleta = rutaGuardadoImagenFoto + "/" + nombreImagenFoto;
        System.out.println("rutaCompleta: " + rutaCompleta);

        ByteArrayResource resource = null;
        byte[] byteReport = null;
        File file = null;
        Path path = null;

        String filename = nombreImagenFoto.toString().trim();

        MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, filename);

        try {
            String filePath = FilenameUtils.normalize(rutaCompleta);
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

}
