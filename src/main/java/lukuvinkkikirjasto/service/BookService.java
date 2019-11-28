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
    public void saveBook(String author, String title, String isbn, int year, String edition) {
        
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setYear(year);
        book.setEdition(edition);
        bookRepository.save(book);
        
    }
    
    /** fetch all books from database */
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
    
    /** fetch a book by id from database */
    public Book getBook(Long id) {
        return bookRepository.getOne(id);
    }
    
}
