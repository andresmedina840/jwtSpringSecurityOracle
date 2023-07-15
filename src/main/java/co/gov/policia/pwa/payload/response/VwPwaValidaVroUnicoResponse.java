package co.gov.policia.pwa.payload.response;

import java.util.List;
import co.gov.policia.pwa.entity.VwPwaValidaVroUnico;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VwPwaValidaVroUnicoResponse {
	
    private List<VwPwaValidaVroUnico> msg;
    private Long code;
    private String message;
    private Long totalResultados;

}
