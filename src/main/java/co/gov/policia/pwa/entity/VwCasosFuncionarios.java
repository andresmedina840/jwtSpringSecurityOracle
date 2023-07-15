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
@Table(schema = "USR_SIGIC", name = "VW_CASOS_FUNCIONARIOS")
public class VwCasosFuncionarios {
	
    @Column(name = "CONSECUTIVO", nullable = false)
    private Long consecutivo;
	
    @Id
	@Column(name = "CONSECUTIVO_EMPLEADO", nullable = false)
    private Long consecutivoEmpelado;
    
    @Column(name = "LEY", nullable = true, length = 4)
    private String ley;
    
    @Column(name = "EMPLEADO", nullable = false)
    private Long empleado;
    
    @Column(name = "IDENTIFICACION", nullable = false)
    private Long identificacion;
    
    @Column(name = "NOMBRES", nullable = true, length = 120)
    private String nombres;
    
    @Column(name = "ROL", nullable = true, length = 2)
    private String rol;
    
    @Column(name = "DESC_ROL", nullable = true, length = 40)
    private String descRol;
    
    @Column(name = "DESC_NIVEL_7", nullable = true, length = 60)
    private String descNivel7;
    
    @Column(name = "DESC_NIVEL_9", nullable = true, length = 60)
    private String descNivel9;
    
    @Column(name = "SIGLA", nullable = false, length = 5)
    private String sigla;
    
    @Column(name = "UNDE_CODIGO", nullable = false, length = 5)
    private String undeCodigo;
    
    @Column(name = "NRO_UNICO", nullable = false, length = 21)
    private String nroUnico;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_HECHO", nullable = true)
    private Date fechaHecho;
    
    @Column(name = "ANO", nullable = false, length = 4)
    private String ano;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota", locale = "es_CO")
    @Column(name = "FECHA_CREACION", nullable = true)
    private Date fechaCreacion;

}
