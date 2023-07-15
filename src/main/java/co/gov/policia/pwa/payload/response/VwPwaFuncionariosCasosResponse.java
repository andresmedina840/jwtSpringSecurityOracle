package co.gov.policia.pwa.payload.response;

import co.gov.policia.pwa.entity.IdentificacionNombreUnidad;
import co.gov.policia.pwa.entity.VwPwaFuncionariosCasos;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VwPwaFuncionariosCasosResponse {

    private VwPwaFuncionariosCasos msg;
    private IdentificacionNombreUnidad msg1;
    private String code;
    private String message;
    private Long consecutivo;

    public VwPwaFuncionariosCasosResponse(VwPwaFuncionariosCasos msg, String code, String message) {
        this.msg = msg;
        this.message = message;
        this.code = code;
    }

    public VwPwaFuncionariosCasosResponse(VwPwaFuncionariosCasos msg, String code, String message, Long consecutivo) {
        this.msg = msg;
        this.message = message;
        this.code = code;
        this.consecutivo = consecutivo;
    }
    
    public VwPwaFuncionariosCasosResponse(VwPwaFuncionariosCasos msg, IdentificacionNombreUnidad msg1, String code, String message) {
        this.msg = msg;
        this.msg1 = msg1;
        this.message = message;
        this.code = code;
    }

}
