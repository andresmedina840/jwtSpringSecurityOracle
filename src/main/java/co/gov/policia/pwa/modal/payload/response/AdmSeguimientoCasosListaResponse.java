package co.gov.policia.pwa.modal.payload.response;

import java.util.List;
import co.gov.policia.pwa.modal.entity.AdmSeguimientoCasosLista;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmSeguimientoCasosListaResponse {
	
	private List<AdmSeguimientoCasosLista> msg;
    private Long code;
    private String message;
    private Long totalResultados;

}
