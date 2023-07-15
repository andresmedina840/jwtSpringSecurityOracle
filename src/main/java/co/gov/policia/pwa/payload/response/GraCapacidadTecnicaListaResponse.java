package co.gov.policia.pwa.payload.response;

import java.util.List;
import co.gov.policia.pwa.entity.GraCapacidadTecnicaLista;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraCapacidadTecnicaListaResponse {

	private List<GraCapacidadTecnicaLista> msg;
	private Long code;
	private String message;
	private Long totalResultados;
}
