package co.gov.policia.pwa.modal.payload.response;

import java.util.List;
import co.gov.policia.pwa.modal.entity.InvestigadoresLista;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuentesHumanasListaResponse {
	
	private List<InvestigadoresLista> msg;
    private Long code;
    private String message;

}
