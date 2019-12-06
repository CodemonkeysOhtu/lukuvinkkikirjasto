package lukuvinkkikirjasto.repository;

import lukuvinkkikirjasto.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author salojuur
 */
@Repository
public interface VideoRepository extends JpaRepository<Video, Long>{
    
}
