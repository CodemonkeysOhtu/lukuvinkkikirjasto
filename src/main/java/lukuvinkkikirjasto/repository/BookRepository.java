package lukuvinkkikirjasto.repository;

import lukuvinkkikirjasto.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author salojuur
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    
}
