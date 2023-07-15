package co.gov.policia.pwa.payload.response;

import java.util.List;
import co.gov.policia.pwa.entity.RepOrdenesTrabajoActividades;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepOrdenesTrabajoActividadesResponse {
	
	private List<RepOrdenesTrabajoActividades> msg;
	private Long code;
	private String message;
	private Long totalResultados;

}
