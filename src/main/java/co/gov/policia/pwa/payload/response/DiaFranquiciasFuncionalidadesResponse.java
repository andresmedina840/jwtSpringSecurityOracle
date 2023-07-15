package co.gov.policia.pwa.payload.response;

import java.util.List;
import co.gov.policia.pwa.modal.entity.DiaFranquiciasFuncionalidades;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaFranquiciasFuncionalidadesResponse {
    
    private List<DiaFranquiciasFuncionalidades> msg;
    private Long code;
    private String message;
    private Long totalResultados;

}
