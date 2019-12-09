package lukuvinkkikirjasto.service;

import java.util.ArrayList;
import java.util.List;
import lukuvinkkikirjasto.entity.Book;
import lukuvinkkikirjasto.repository.BookRepository;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
public class BookServiceTest {
    
    /*
    @TestConfiguration
    public class BookServiceTestContextConfiguration {
        
        @Bean
        public BookService getBookService() {
            return new BookService();
        }
    }

    @Autowired
    private BookService bookService;
    
    @MockBean
    private BookRepository bookRepository;
    
    private Book book;
    
    @Before
    public void setUp() throws Exception {
        String author = "Robert Martin";
        String title = "Clean Code";
        String isbn = "978-0132350884";
        book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        book.setIsbn(isbn);
        
        Mockito.when(bookRepository.findAll().get(0).getAuthor()).thenReturn("Robert Martin");
        
    }
    
    @Test
    public void validAuthorIsReturned() {
        assertEquals("Robert Martin", bookService.getBooks().get(0).getAuthor());
    }
    */
}

