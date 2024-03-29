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
    public Blogpost saveBlogpost(String author, String title, String url, List<String> tagit, List<String> relatedCourses) {
        
        Blogpost blogpost = new Blogpost();
        blogpost.setAuthor(author);
        blogpost.setTitle(title);
        blogpost.setUrl(url);
        blogpost.setTagit(tagit);
        blogpost.setRelatedCourses(relatedCourses);
        blogpost.setType("blogpost");
        return blogpostRepository.save(blogpost);
        
    }

    public Blogpost saveBlogpost(Blogpost blogpost) {
        blogpost.setType("blogpost");
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

    public boolean deleteById(Long id) {
      try {
        blogpostRepository.deleteById(id);
      } catch(Exception e) {
        return false;
      }

      return true;
    }
    
}
