package lukuvinkkikirjasto.repository;

import lukuvinkkikirjasto.entity.Blogpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author salojuur
 */
@Repository
public interface BlogpostRepository extends JpaRepository<Blogpost, Long>{
    
}
