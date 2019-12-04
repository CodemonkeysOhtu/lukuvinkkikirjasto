package lukuvinkkikirjasto.service;

import java.time.LocalDate;
import java.util.List;
import lukuvinkkikirjasto.entity.Article;
import lukuvinkkikirjasto.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    
    @Autowired
    private ArticleRepository articleRepository;
    
    /** save article in database
     * @param author article author
     * @param title article title
     * @param localDate date published
     * @param publisher journal/magazine etc. that published article
     * @param tagit user's tags
     * @param related titles of related articles
     */
    public Article saveArticle(String author, String title, LocalDate localDate, String publisher, List<String> tagit, List<String> related) {
        
        Article article = new Article();
        article.setAuthor(author);
        article.setTitle(title);
        article.setLocalDate(localDate);
        article.setPublisher(publisher);
        article.setTagit(tagit);
        article.setRelated(related);
        article.setType("article");
        return articleRepository.save(article);
        
    }

    public Article saveArticle(Article article) {
        article.setType("article");
        return articleRepository.save(article);
    }
    
    /** fetch all articles from database */
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }
    
    /** fetch an article by id from database */
    public Article getArticle(Long id) {
        return articleRepository.getOne(id);
    }
    
}
