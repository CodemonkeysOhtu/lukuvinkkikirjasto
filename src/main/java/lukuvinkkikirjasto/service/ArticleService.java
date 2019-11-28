package lukuvinkkikirjasto.service;

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
     * @param year year published
     * @param month month published
     * @param publisher journal/magazine etc. that published article
     */
    public void saveArticle(String author, String title, int year, int month, String publisher) {
        
        Article article = new Article();
        article.setAuthor(author);
        article.setTitle(title);
        article.setYear(year);
        article.setMonth(month);
        article.setPublisher(publisher);
        articleRepository.save(article);
        
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
