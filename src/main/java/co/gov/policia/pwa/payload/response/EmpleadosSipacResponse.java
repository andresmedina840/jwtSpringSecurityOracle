package co.gov.policia.pwa.payload.response;

import co.gov.policia.pwa.entity.EmpleadosSipac;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadosSipacResponse {

	private EmpleadosSipac usuario;
	private String code;
	private String message;

}
