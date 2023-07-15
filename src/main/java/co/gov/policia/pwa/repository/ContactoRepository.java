package co.gov.policia.pwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.gov.policia.pwa.entity.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {

}
