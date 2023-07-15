package co.gov.policia.pwa.payload.response;

import co.gov.policia.pwa.entity.VwPwaCasos;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VwPwaCasoshResponse {

	private VwPwaCasos msg;
	private String code;
	private String message;
	private Long consecutivo;

	public VwPwaCasoshResponse(VwPwaCasos msg, String code, String message) {
		this.msg = msg;
		this.message = message;
		this.code = code;
	}

	public VwPwaCasoshResponse(VwPwaCasos msg, String code, String message, Long consecutivo) {
		this.msg = msg;
		this.message = message;
		this.code = code;
		this.consecutivo = consecutivo;

	}

}
