package lukuvinkkikirjasto.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class BookTest {
    private Book book;

    @Test
    public void initializationTest() {
        String author = "Robert Martin";
        String title = "Clean Code";
        String isbn = "978-0132350884";
        int year = 2008;
        String edition = "1"; 
        List<String> tagit = new ArrayList<>();
        tagit.add("tags");
        List<String> related = new ArrayList<>();
        related.add("Another boook");
        book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setYear(year);
        book.setEdition(edition);
        book.setTagit(tagit);
        book.setRelated(related);

        assertEquals(book.getAuthor(), author);
        assertEquals(book.getTitle(), title);
        assertEquals(book.getIsbn(), isbn);
        assertEquals(book.getYear(), year);
        assertEquals(book.getEdition(), edition);
        assertEquals(book.getTagit(), tagit);
        assertEquals(book.getRelated(), related);
    }
}

