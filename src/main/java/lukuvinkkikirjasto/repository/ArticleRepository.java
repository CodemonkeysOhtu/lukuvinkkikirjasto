package lukuvinkkikirjasto.repository;

import lukuvinkkikirjasto.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author salojuur
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{
    
}