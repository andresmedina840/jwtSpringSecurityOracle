package co.gov.policia.pwa.payload.response;

import co.gov.policia.pwa.entity.VwPwaBitacoraCasos;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VwPwaBitacoraCasosResponse {

    private VwPwaBitacoraCasos msg;
    private String code;
    private String message;
    private Long consecutivo;

    public VwPwaBitacoraCasosResponse(VwPwaBitacoraCasos msg, String code, String message) {
        this.msg = msg;
        this.message = message;
        this.code = code;
    }

    public VwPwaBitacoraCasosResponse(VwPwaBitacoraCasos msg, String code, String message, Long consecutivo) {
        this.msg = msg;
        this.message = message;
        this.code = code;
        this.consecutivo = consecutivo;

    }

}
