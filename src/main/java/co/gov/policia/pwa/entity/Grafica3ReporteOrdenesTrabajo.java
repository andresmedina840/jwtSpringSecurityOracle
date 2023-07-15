package co.gov.policia.pwa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grafica3ReporteOrdenesTrabajo {
	
	private Long mes;
	private String nombreMes;
	private Long totalOrdenesTrabajo;
	private Long totalActividades;
	private Float promedio;
	private Long calificacion;
	private String puntuacion;
	private String color;
	private String codigoColorHexa;
	private String codigoColorRgba;

}
