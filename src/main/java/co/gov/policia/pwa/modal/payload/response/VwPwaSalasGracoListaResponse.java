package co.gov.policia.pwa.modal.payload.response;

import java.util.List;
import co.gov.policia.pwa.modal.entity.VwPwaSalasGracoLista;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VwPwaSalasGracoListaResponse {
	
	private List<VwPwaSalasGracoLista> msg;
    private Long code;
    private String message;
    private Long totalDeRegistros;

}
