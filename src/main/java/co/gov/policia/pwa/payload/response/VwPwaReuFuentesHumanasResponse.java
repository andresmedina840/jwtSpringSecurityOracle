package co.gov.policia.pwa.payload.response;

import co.gov.policia.pwa.entity.VwPwaReuFuentesHumanas;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VwPwaReuFuentesHumanasResponse {

    private VwPwaReuFuentesHumanas msg;
    private String code;
    private String message;
    private Long consecutivo;

    public VwPwaReuFuentesHumanasResponse(VwPwaReuFuentesHumanas msg, String code, String message) {
        this.msg = msg;
        this.message = message;
        this.code = code;
    }

    public VwPwaReuFuentesHumanasResponse(VwPwaReuFuentesHumanas msg, String code, String message, Long consecutivo) {
        this.msg = msg;
        this.message = message;
        this.code = code;
        this.consecutivo = consecutivo;
    }

}
