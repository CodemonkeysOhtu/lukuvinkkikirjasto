package lukuvinkkikirjasto.controller;

import java.util.ArrayList;
import java.util.List;
import lukuvinkkikirjasto.entity.Book;
import lukuvinkkikirjasto.service.BookService;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {
    
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private BookService bookService;
    
    @Test
    public void givenBooks_whenGetBooks_thenReturnsJsonArray() throws Exception {
        Book book = new Book();
        book.setAuthor("Robert Martin");
        
        List<Book> books = new ArrayList<>();
        books.add(book);
        
        given(bookService.getBooks()).willReturn(books);
        
        mvc.perform(MockMvcRequestBuilders.get("/books").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].author", is(book.getAuthor())));
        
    }
    
}