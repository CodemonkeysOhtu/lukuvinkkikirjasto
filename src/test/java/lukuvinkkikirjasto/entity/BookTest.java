package lukuvinkkikirjasto.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
    private Book book;

    @Test
    public void initializationTest() {
        String author = "Robert Martin";
        String title = "Clean Code";
        String isbn = "978-0132350884";
        int year = 2008;
        String edition = "1"; 
        book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setYear(year);
        book.setEdition(edition);

        assertEquals(book.getAuthor(), author);
        assertEquals(book.getTitle(), title);
        assertEquals(book.getIsbn(), isbn);
        assertEquals(book.getYear(), year);
        assertEquals(book.getEdition(), edition);
    }
}

