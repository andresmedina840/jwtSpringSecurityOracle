package co.gov.policia.pwa.payload.response;

import java.util.List;
import co.gov.policia.pwa.entity.VwPwaTrazabilidadTramiteGraco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VwPwaTrazabilidadTramiteGracoResponse {
	
    private List<VwPwaTrazabilidadTramiteGraco> msg;
    private Long code;
    private String message;
    private Long totalResultados;

}
