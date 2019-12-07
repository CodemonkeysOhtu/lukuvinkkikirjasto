package lukuvinkkikirjasto.controller;

import java.util.List;
import lukuvinkkikirjasto.entity.Article;
import lukuvinkkikirjasto.service.ArticleService;
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
public class ArticleController {
    
    @Autowired
    private ArticleService articleService;
    
    @RequestMapping(value = "/articles", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<Article>> getArticles() {
      List<Article> articles = articleService.getArticles();
      if(articles == null || articles.isEmpty()) {
        return ResponseEntity.ok(articles);
      }
      return ResponseEntity.ok(articles);
    }

    @RequestMapping(value = "/articles", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Article> postOneArticle(@RequestBody Article article) {
      Article savedArticle = articleService.saveArticle(article);
      return ResponseEntity.ok(savedArticle);
    }

    @DeleteMapping("/articles/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteOne(@PathVariable Long id) {
      boolean response = articleService.deleteById(id);
      return response ?
          ResponseEntity.ok("Success!") :
          ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to delete object!");
    }
}
