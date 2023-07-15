package co.gov.policia.pwa.payload.response;

import co.gov.policia.pwa.entity.VwPwaDiaDia;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VwPwaDiaDialResponse {

	private VwPwaDiaDia msg;
	private String code;
	private String message;
	private Long consecutivo;

	public VwPwaDiaDialResponse(VwPwaDiaDia msg, String code, String message) {
		this.msg = msg;
		this.message = message;
		this.code = code;
	}

	public VwPwaDiaDialResponse(VwPwaDiaDia msg, String code, String message, Long consecutivo) {
		this.msg = msg;
		this.message = message;
		this.code = code;
		this.consecutivo = consecutivo;

	}

}
