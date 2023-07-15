package co.gov.policia.pwa.payload.response;

import java.util.List;
import co.gov.policia.pwa.entity.Grafica1ReporteOrdenesTrabajo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grafica1ReporteOrdenesTrabajoResponse {
	
    private List<Grafica1ReporteOrdenesTrabajo> msg;
    private Long code;
    private String message;
    private Long totalResultados;

}
