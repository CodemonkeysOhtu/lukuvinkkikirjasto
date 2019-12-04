package lukuvinkkikirjasto.entity;

import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArticleTest {
    private Article article;

    @Test
    public void initializationTest() {
        String author = "Claire Donald";
        String title = "An Introduction To: Agile Software Development";
        String publisher = "SheCanCode";
        LocalDate localDate = LocalDate.of(2017,11,30);
        List<String> tagit = new ArrayList<>();
        tagit.add("tags");
        List<String> related = new ArrayList<>();
        related.add("Another Article");
        article = new Article();
        article.setAuthor(author);
        article.setTitle(title);
        article.setPublisher(publisher);
        article.setLocalDate(localDate);
        article.setTagit(tagit);
        article.setRelated(related);

        assertEquals(article.getAuthor(), author);
        assertEquals(article.getTitle(), title);
        assertEquals(article.getPublisher(), publisher);
        assertEquals(article.getLocalDate(), localDate);
        assertEquals(article.getTagit(), tagit);
        assertEquals(article.getRelated(), related);
    }
}

