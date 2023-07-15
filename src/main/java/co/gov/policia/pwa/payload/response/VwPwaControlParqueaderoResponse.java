package co.gov.policia.pwa.payload.response;

import java.util.List;
import co.gov.policia.pwa.entity.VwPwaControlParqueadero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VwPwaControlParqueaderoResponse {
	
    private List<VwPwaControlParqueadero> msg;
    private Long code;
    private String message;
    private Long totalResultados;

}