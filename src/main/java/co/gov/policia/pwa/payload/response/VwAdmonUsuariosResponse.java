package co.gov.policia.pwa.payload.response;

import co.gov.policia.pwa.entity.VwPwaAdminUsuarios;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VwAdmonUsuariosResponse {
	
	private VwPwaAdminUsuarios msg;
	private String code;
	private String message;
	
}
