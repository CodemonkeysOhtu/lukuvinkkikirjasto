package lukuvinkkikirjasto.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BlogpostTest {
    private Blogpost blogpost;

    @Test
    public void initializationTest() {
        String author = "Amit Solanki";
        String title = "Optional Chaining for Javascript - ES proposal";
        String url = "https://dev.to/iamsolankiamit/optional-chaining-for-javascript-es-proposal-3c26";
        blogpost = new Blogpost();
        blogpost.setAuthor(author);
        blogpost.setTitle(title);
        blogpost.setUrl(url);

        assertEquals(blogpost.getAuthor(), author);
        assertEquals(blogpost.getTitle(), title);
        assertEquals(blogpost.getUrl(), url);
    }
}

