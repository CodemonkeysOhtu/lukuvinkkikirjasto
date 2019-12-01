package lukuvinkkikirjasto.controller;

import java.util.List;
import lukuvinkkikirjasto.entity.Article;
import lukuvinkkikirjasto.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    public ResponseEntity<Article> postOneBlogpost(@RequestBody Article article) {
      Article savedArticle = articleService.saveArticle(article.getAuthor(), article.getTitle(), article.getLocalDate(), article.getPublisher(), article.getTagit(), article.getRelated());
      return ResponseEntity.ok(savedArticle);
    }
}
