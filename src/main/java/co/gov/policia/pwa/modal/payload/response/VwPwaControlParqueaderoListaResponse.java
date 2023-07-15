package co.gov.policia.pwa.modal.payload.response;

import java.util.List;
import co.gov.policia.pwa.modal.entity.VwPwaControlParqueaderoLista;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VwPwaControlParqueaderoListaResponse {
	
	private List<VwPwaControlParqueaderoLista> msg;
    private Long code;
    private String message;
    private Long totalDeRegistros;

}
