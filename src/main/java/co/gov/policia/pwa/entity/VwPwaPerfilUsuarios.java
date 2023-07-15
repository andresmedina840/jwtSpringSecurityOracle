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
@Table(schema = "USR_SIGIC", name = "VW_PWA_PERFIL_USUARIOS")
public class VwPwaPerfilUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FUNCION", nullable = true, length = 30)
    private String funcion;

    @Column(name = "USUARIO", nullable = false, length = 30)
    private String usuario;
    
    @Column(name = "NOMBRE_FUNCION", nullable = false, length = 100)
    private String nombreFuncion;

}
