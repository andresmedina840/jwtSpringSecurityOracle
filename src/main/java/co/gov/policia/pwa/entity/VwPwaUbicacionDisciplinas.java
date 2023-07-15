package co.gov.policia.pwa.entity;

import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Cacheable(false)
@Table(name = "VW_PWA_UBICACION_DISCIPLINAS")
public class VwPwaUbicacionDisciplinas implements Serializable {

    private static final long serialVersionUID = 1L;
  
    @Column(name = "UNIDAD", nullable = true, length = 108)
    private String unidad;
    
    @Id
    @Column(name = "CODIGO_UNIDAD", nullable = false)
    private Long codigoUnidad;
    
    @Column(name = "REGIONAL", nullable = true, length = 108)
    private String regional;
    
    @Column(name = "CODIGO_REGIONAL", nullable = false)
    private Long codigoRegional;
    
    @Column(name = "MUNICIPIO", nullable = true, length = 203)
    private String municipio;
    
    @Column(name = "CODIGO_MUNICIPIO", nullable = false)
    private Long codigoMunicipio;
    
    @Column(name = "DIRECCION_LABORATORIO", nullable = true, length = 100)
    private String direccionLaboratorio;

    @Column(name = "TELEFONO", nullable = true, length = 20)
    private String telefono;
    
    @Column(name = "ID_DISCIPLINA", nullable = false)
    private Long idDisciplina;
    
}
