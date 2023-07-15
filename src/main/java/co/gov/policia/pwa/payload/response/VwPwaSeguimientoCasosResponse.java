package co.gov.policia.pwa.payload.response;

import co.gov.policia.pwa.entity.VwPwaSeguimientoCasos;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VwPwaSeguimientoCasosResponse {

    private VwPwaSeguimientoCasos msg;
    private String code;
    private String message;
    private Long consecutivo;

    public VwPwaSeguimientoCasosResponse(VwPwaSeguimientoCasos msg, String code, String message) {
        this.msg = msg;
        this.message = message;
        this.code = code;
    }

    public VwPwaSeguimientoCasosResponse(VwPwaSeguimientoCasos msg, String code, String message, Long consecutivo) {
        this.msg = msg;
        this.message = message;
        this.code = code;
        this.consecutivo = consecutivo;
    }

}
