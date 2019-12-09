package lukuvinkkikirjasto.repository;

import java.util.ArrayList;
import java.util.List;
import lukuvinkkikirjasto.entity.Video;
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
public class VideoRepositoryTest {
    
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private TestEntityManager entityManager;
    
    private Video video;
    
    @Before
    public void setUp() throws Exception {
        String author = "Mark Shead";
        String title = "What is Agile?";
        String url = "https://youtu.be/Z9QbYZh1YXY";
        String comment = "Good.";
        List<String> relatedCourses = new ArrayList<>();
        relatedCourses.add("Another video");
        video = new Video();
        video.setAuthor(author);
        video.setTitle(title);
        video.setUrl(url);
        video.setComment(comment);
        video.setRelatedCourses(relatedCourses);
        // Testentitymanager inserts video in DB
        entityManager.persist(video);
        entityManager.flush();
        
    }
    
    @Test
    public void articleRepositoryWorks() {
        List<Video> videos = videoRepository.findAll();
        assertNotNull(videos);
        Video video = videos.get(0);
        assertEquals("https://youtu.be/Z9QbYZh1YXY", video.getUrl());                
    }
    
}

