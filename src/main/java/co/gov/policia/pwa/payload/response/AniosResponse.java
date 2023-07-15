package co.gov.policia.pwa.payload.response;

import java.util.List;
import co.gov.policia.pwa.entity.Anios;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AniosResponse {
	
	private List<Anios> msg;
	private Long code;
	private String message;
	private Long totalResultados;

}
