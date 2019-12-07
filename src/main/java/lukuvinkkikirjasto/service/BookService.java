package lukuvinkkikirjasto.service;

import java.util.List;
import lukuvinkkikirjasto.entity.Book;
import lukuvinkkikirjasto.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;
    
    /** save book in database */
    public Book saveBook(String author, String title, String isbn, int year, String edition, List<String> tagit, List<String> related) {
        
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setYear(year);
        book.setEdition(edition);
        book.setTagit(tagit);
        book.setRelated(related);
        book.setType("book");
        return bookRepository.save(book);
        
    }

    public Book saveBook(Book book) {
      book.setType("book");
      return bookRepository.save(book);
    }
    
    /** fetch all books from database */
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
    
    /** fetch a book by id from database */
    public Book getBook(Long id) {
        return bookRepository.getOne(id);
    }

    public boolean deleteById(Long id) {
      try {
        bookRepository.deleteById(id);
      } catch(Exception e) {
        return false;
      }

      return true;
    }
    
}
