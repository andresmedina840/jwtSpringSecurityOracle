package co.gov.policia.pwa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraCapacidadTecnicaLista {

	private Long consecutivo;

	private Long undeCodigo;

    private Long totalClaro;
    
    private Long ocupadoClaro;
    
    private String porcentajeRestanteClaro;
    
    private Long totalMovistar;
    
    private Long ocupadoMovistar;
    
    private String porcentajeRestanteMovistar;
    
    private Long totalTigo;
    
    private Long ocupadoTigo;
    
    private String porcentajeRestanteTigo;
    
    private Long totalWom;
    
    private Long ocupadoWom;
    
    private String porcentajeRestanteWom;
    
    private Long totalCapacidad;
    
    private Long totalOcupado;
    
    private String porcentajeRestanteTotales;

}
