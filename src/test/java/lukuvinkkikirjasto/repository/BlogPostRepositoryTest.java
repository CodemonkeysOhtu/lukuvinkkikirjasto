package lukuvinkkikirjasto.repository;

import java.util.ArrayList;
import java.util.List;
import lukuvinkkikirjasto.entity.Blogpost;
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
public class BlogPostRepositoryTest {
    
    @Autowired
    private BlogpostRepository blogpostRepository;
    @Autowired
    private TestEntityManager entityManager;
    
    private Blogpost blogpost;
    
    @Before
    public void setUp() throws Exception {
        String author = "Amit Solanki";
        String title = "Optional Chaining for Javascript - ES proposal";
        String url = "https://dev.to/iamsolankiamit/optional-chaining-for-javascript-es-proposal-3c26";
        List<String> relatedCourses = new ArrayList<>();
        relatedCourses.add("course2");
        blogpost = new Blogpost();
        blogpost.setAuthor(author);
        blogpost.setTitle(title);
        blogpost.setUrl(url);
        blogpost.setRelatedCourses(relatedCourses);
        // Testentitymanager inserts blogpost in DB
        entityManager.persist(blogpost);
        entityManager.flush();
        
    }
    
    @Test
    public void articleRepositoryWorks() {
        List<Blogpost> blogposts = blogpostRepository.findAll();
        assertNotNull(blogposts);
        Blogpost blogpost = blogposts.get(0);
        assertEquals("Amit Solanki", blogpost.getAuthor());                
    }
    
}

