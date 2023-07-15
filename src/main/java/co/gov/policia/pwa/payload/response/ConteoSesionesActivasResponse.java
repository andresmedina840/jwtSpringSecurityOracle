package co.gov.policia.pwa.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConteoSesionesActivasResponse {
	
	private Long msg;
	private Long code;
	private String message;

}
