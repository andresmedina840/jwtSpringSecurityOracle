package co.gov.policia.pwa.payload.response;

import java.util.List;
import co.gov.policia.pwa.entity.BuscarNoticiaCriminal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuscarNoticiaCriminalResponse {
    
    private List<BuscarNoticiaCriminal> msg;
    private Long code;
    private String message;
    private Long totalResultados;

}
