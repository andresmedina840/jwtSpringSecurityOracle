package co.gov.policia.pwa.payload.response;

import java.util.List;
import co.gov.policia.pwa.entity.Grafica3ReporteOrdenesTrabajo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grafica3ReporteOrdenesTrabajoResponse {
	
    private List<Grafica3ReporteOrdenesTrabajo> msg;
    private Long code;
    private String message;
    private Long totalResultados;

}
