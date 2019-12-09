package lukuvinkkikirjasto.controller;

import java.util.ArrayList;
import java.util.List;
import lukuvinkkikirjasto.entity.Article;
import lukuvinkkikirjasto.service.ArticleService;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ArticleController.class)
public class ArticleControllerTest {
    
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private ArticleService articleService;
    
    @Test
    public void givenArticles_whenGetArticles_thenReturnsJsonArray() throws Exception {
        Article article = new Article();
        article.setTitle("An Introduction To: Agile Software Development");
        
        List<Article> articles = new ArrayList<>();
        articles.add(article);
        
        given(articleService.getArticles()).willReturn(articles);
        
        mvc.perform(MockMvcRequestBuilders.get("/articles").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is(article.getTitle())));
        
    }
    
}