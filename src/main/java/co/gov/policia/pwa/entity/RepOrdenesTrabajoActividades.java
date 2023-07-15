package co.gov.policia.pwa.entity;

import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Cacheable(false)
@Table(schema = "USR_SIGIC",name = "REP_ORDENES_TRABAJO_ACTIVIDADES")
public class RepOrdenesTrabajoActividades {
	
	@Id
	@Column(name = "CONSECUTIVO", nullable = false)
	private Long consecutivo;
	
	@Column(name = "REGIONAL", nullable = true, length = 6)
	private String regional;

	@Column(name = "UNIDAD", nullable = false, length = 6)
	private String unidad;
	
	@Column(name = "ANIO", nullable = false)
	private Long anio;
	
	@Column(name = "MES", nullable = false)
	private Long mes;
	
	@Column(name = "TOTAL_OT", nullable = false)
	private Long totalOt;
	
	@Column(name = "TOTAL_AC", nullable = false)
	private Long totalAc;
		
	@Column(name = "USUARIO_CREADOR", nullable = true, length = 30)
	private String usuarioCreador;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_CREACION", nullable = true)
	private Date fechaCreacion;

	@Column(name = "USUARIO_MODIFICADOR", nullable = true, length = 30)
	private String usuarioModificador;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
	@Column(name = "FECHA_MODIFICACION", nullable = true)
	private Date fechaModificacion;

}
