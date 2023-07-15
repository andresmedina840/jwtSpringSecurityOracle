package co.gov.policia.pwa.entity;

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
@Table(schema = "USR_SIGIC", name = "VW_PWA_ADMIN_USUARIOS_NACIONAL")
public class VwPwaAdminUsuariosNacional {

    @Id
    @Column(name = "CONSECUTIVO", nullable = false)
    private Long consecutivo;
    
    @Column(name = "UNDE_CODIGO_SIPAC", nullable = false)
    private Long undeCodigoSipac;
    
    @Column(name = "UNIDAD", nullable = true, length = 108)
    private String unidad;
    
    @Column(name = "NOMBRES", nullable = true, length = 128)
    private String nombres;
    
    @Column(name = "IDENTIFICACION", nullable = false)
    private Long identificacion;

    @Column(name = "USUARIO_SIPAC", nullable = true, length = 30)
    private String usuarioSipac;
    
    @Column(name = "CORREO_ELECTRONICO", nullable = true, length = 50)
    private String correoElectronico;
    
    @Column(name = "ACTIVO", nullable = true, length = 2)
    private String activo;

    @Column(name = "AUTORIZADO", nullable = true)
    private Long autorizado;

    @Column(name = "REGIONAL", nullable = false, length = 5)
    private String regional;
	
}
