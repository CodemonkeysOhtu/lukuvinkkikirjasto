package lukuvinkkikirjasto.service;

import java.util.List;
import lukuvinkkikirjasto.entity.Blogpost;
import lukuvinkkikirjasto.repository.BlogpostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogpostService {
    
    @Autowired
    private BlogpostRepository blogpostRepository;
    
    /** save blogpost in database */
    public Blogpost saveBlogpost(String author, String title, String url) {
        
        Blogpost blogpost = new Blogpost();
        blogpost.setAuthor(author);
        blogpost.setTitle(title);
        blogpost.setUrl(url);
        return blogpostRepository.save(blogpost);
        
    }
    
    /** fetch all blogposts from database */
    public List<Blogpost> getBlogposts() {
        return blogpostRepository.findAll();
    }
    
    /** fetch a blogpost by id from database */
    public Blogpost getBlogpost(Long id) {
        return blogpostRepository.getOne(id);
    }
    
}
