package co.gov.policia.pwa.payload.response;

import java.util.List;
import co.gov.policia.pwa.entity.DiaTipoActividades;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaTipoActividadesResponse {
	
    private List<DiaTipoActividades> msg;
    private Long code;
    private String message;
    private Long totalResultados;

}
