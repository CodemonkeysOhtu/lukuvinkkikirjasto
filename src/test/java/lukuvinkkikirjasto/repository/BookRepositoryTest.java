package lukuvinkkikirjasto.repository;

import java.util.ArrayList;
import java.util.List;
import lukuvinkkikirjasto.entity.Book;
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
public class BookRepositoryTest {
    
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TestEntityManager entityManager;
    
    private Book book;
    
    @Before
    public void setUp() throws Exception {
        book = new Book();
        book.setAuthor("Robert Martin");
        book.setTitle("Clean Code");
        book.setIsbn("978-0132350884");
        book.setYear(2008);
        book.setEdition("1");
        List<String> tags = new ArrayList<>();
        book.setTagit(tags);
        List<String> related = new ArrayList<>();
        book.setRelated(related);
        book.setType("book");
        // Testentitymanager inserts book in DB
        entityManager.persist(book);
        entityManager.flush();
    }
    
    @Test
    public void bookRepositoryWorks() {
        List<Book> books = bookRepository.findAll();
        assertNotNull(books);
        Book book = books.get(0);
        assertEquals("Clean Code", book.getTitle());                
    }
    
}

