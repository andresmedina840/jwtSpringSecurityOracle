package co.gov.policia.pwa.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

	private String usuario;
	private String contrasenia;
	private String navegador;

}
