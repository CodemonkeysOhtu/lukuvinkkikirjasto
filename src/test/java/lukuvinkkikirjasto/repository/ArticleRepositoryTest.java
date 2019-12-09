package lukuvinkkikirjasto.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lukuvinkkikirjasto.entity.Article;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArticleRepositoryTest {
    
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private TestEntityManager entityManager;
    
    private Article article;
    
    @Before
    public void setUp() throws Exception {
        article = new Article();
        article.setAuthor("Claire Donald");
        article.setTitle("An Introduction To: Agile Software Development");
        article.setPublisher("SheCanCode");
        article.setLocalDate(LocalDate.of(2017,11,30));
        List<String> tagit = new ArrayList<>();
        article.setTagit(tagit);
        List<String> related = new ArrayList<>();
        article.setRelated(related);
        // Testentitymanager inserts article in DB
        entityManager.persist(article);
        entityManager.flush();
        
    }
    
    @Test
    public void articleRepositoryWorks() {
        List<Article> articles = articleRepository.findAll();
        assertNotNull(articles);
        Article article = articles.get(0);
        assertEquals("An Introduction To: Agile Software Development", article.getTitle());                
    }
    
}

