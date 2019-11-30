package lukuvinkkikirjasto.controller;

import java.util.List;
import lukuvinkkikirjasto.entity.Blogpost;
import lukuvinkkikirjasto.service.BlogpostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BlogpostController {
    
    @Autowired
    private BlogpostService blogpostService;
    
    @RequestMapping(value = "/blogposts", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<Blogpost>> getBlogposts() {
      List<Blogpost> blogposts = blogpostService.getBlogposts();
      if(blogposts == null || blogposts.isEmpty()) {
        return ResponseEntity.ok(blogposts);
      }
      return ResponseEntity.ok(blogposts);
    }

    @RequestMapping(value = "/blogposts", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity postOneBlogpost(@RequestBody Blogpost blogpost) {
      Blogpost savedBlogpost = blogpostService.saveBlogpost(blogpost.getAuthor(), blogpost.getTitle(), blogpost.getUrl(), blogpost.getRelatedCourses());
      return ResponseEntity.ok(savedBlogpost);
    }
}
