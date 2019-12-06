package lukuvinkkikirjasto.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class BlogpostTest {
    private Blogpost blogpost;

    @Test
    public void initializationTest() {
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

        assertEquals(blogpost.getAuthor(), author);
        assertEquals(blogpost.getTitle(), title);
        assertEquals(blogpost.getUrl(), url);
        assertEquals(blogpost.getRelatedCourses(), relatedCourses);
    }
}

