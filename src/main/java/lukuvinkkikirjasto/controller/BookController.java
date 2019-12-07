package lukuvinkkikirjasto.controller;

import java.util.List;
import lukuvinkkikirjasto.entity.Book;
import lukuvinkkikirjasto.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    @RequestMapping(value = "/books", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<Book>> getBooks() {
      List<Book> books = bookService.getBooks();
      if(books == null || books.isEmpty()) {
        return ResponseEntity.ok(books);
      }
      return ResponseEntity.ok(books);
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Book> postOneBlogpost(@RequestBody Book book) {
      Book savedBook = bookService.saveBook(book);
      return ResponseEntity.ok(savedBook);
    }

    @DeleteMapping("/books/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
      boolean response = bookService.deleteById(id);
      return response ?
          ResponseEntity.ok("Success!") :
          ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to delete object!");
    }
}
