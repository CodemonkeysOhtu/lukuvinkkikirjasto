package lukuvinkkikirjasto.controller;

import java.util.ArrayList;
import java.util.List;
import lukuvinkkikirjasto.entity.Blogpost;
import lukuvinkkikirjasto.service.BlogpostService;
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
@WebMvcTest(BlogpostController.class)
public class BlogpostControllerTest {
    
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private BlogpostService blogpostService;
    
    @Test
    public void givenBlogposts_whenGetBlogposts_thenReturnsJsonArray() throws Exception {
        Blogpost blogpost = new Blogpost();
        blogpost.setAuthor("Amit Solanki");
        
        List<Blogpost> blogposts = new ArrayList<>();
        blogposts.add(blogpost);
        
        given(blogpostService.getBlogposts()).willReturn(blogposts);
        
        mvc.perform(MockMvcRequestBuilders.get("/blogposts").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].author", is(blogpost.getAuthor())));
        
    }
    
}