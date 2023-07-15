package co.gov.policia.pwa.payload.response;

import java.util.List;
import co.gov.policia.pwa.entity.Anios;
import co.gov.policia.pwa.entity.ReportesOrdenesTrabajo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportesOrdenesTrabajoResponse {
	
	private List<ReportesOrdenesTrabajo> msg;
	private List<Anios> msg1;
	private Long code;
	private String message;
	private Long totalResultados;

}
