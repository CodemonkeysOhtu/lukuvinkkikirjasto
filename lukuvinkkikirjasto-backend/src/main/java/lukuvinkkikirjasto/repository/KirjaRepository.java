package lukuvinkkikirjasto.repository;

import lukuvinkkikirjasto.entity.Kirja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author salojuur
 */
@Repository
public interface KirjaRepository extends JpaRepository<Kirja, Long> {
    
}
