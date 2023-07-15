package co.gov.policia.pwa.payload.response;

import java.util.List;
import co.gov.policia.pwa.entity.GraCapacidadTecnica;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GraCapacidadTecnicaResponse {
	
	private List<GraCapacidadTecnica> msg;
	private Long code;
	private String message;
	private Long totalResultados;

}
