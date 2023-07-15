package co.gov.policia.pwa.payload.response;

import java.util.List;
import co.gov.policia.pwa.entity.VwCasosFuncionarios;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VwCasosFuncionariosResponse {
	
	private List<VwCasosFuncionarios> msg;
	private Long code;
	private String message;
	private Long totalResultados;

}
