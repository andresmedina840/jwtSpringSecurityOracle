package co.gov.policia.pwa.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileResponse {
    
    private String message;
    private String nombrearchivo;
    private String tipoarchivo;
    private String nombreruta;
    private String nombreArchivoGuardado;
    private String rutaCompletaGuardado;
    private String tamanoArchivo;


}
