package lukuvinkkikirjasto.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VideoTest {
    private Video video;

    @Test
    public void initializationTest() {
        String author = "Mark Shead";
        String title = "What is Agile?";
        String url = "https://youtu.be/Z9QbYZh1YXY";
        String comment = "Good.";
        String relatedCourses = "Another video";
        video = new Video();
        video.setAuthor(author);
        video.setTitle(title);
        video.setUrl(url);
        video.setComment(comment);
        video.setRelatedCourses(relatedCourses);

        assertEquals(video.getAuthor(), author);
        assertEquals(video.getTitle(), title);
        assertEquals(video.getUrl(), url);
        assertEquals(video.getComment(), comment);
        assertEquals(video.getRelatedCourses(), relatedCourses);
    }
}

