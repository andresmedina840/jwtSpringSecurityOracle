package co.gov.policia.pwa.payload.response;

import co.gov.policia.pwa.entity.VwPwaFranquicia;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VwPwaFranquicivResponse {

	private VwPwaFranquicia msg;
	private String code;
	private String message;
	private Long consecutivo;

	public VwPwaFranquicivResponse(VwPwaFranquicia msg, String code, String message) {
		this.msg = msg;
		this.message = message;
		this.code = code;
	}

	public VwPwaFranquicivResponse(VwPwaFranquicia msg, String code, String message, Long consecutivo) {
		this.msg = msg;
		this.message = message;
		this.code = code;
		this.consecutivo = consecutivo;

	}

}
