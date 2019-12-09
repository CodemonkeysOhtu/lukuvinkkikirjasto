package lukuvinkkikirjasto.controller;

import java.util.ArrayList;
import java.util.List;
import lukuvinkkikirjasto.entity.Video;
import lukuvinkkikirjasto.service.VideoService;
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
@WebMvcTest(VideoController.class)
public class VideoControllerTest {
    
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private VideoService videoService;
    
    @Test
    public void givenVideos_whenGetVideos_thenReturnsJsonArray() throws Exception {
        Video video = new Video();
        video.setUrl("https://youtu.be/Z9QbYZh1YXY");
        
        List<Video> videos = new ArrayList<>();
        videos.add(video);
        
        given(videoService.getVideos()).willReturn(videos);
        
        mvc.perform(MockMvcRequestBuilders.get("/videos").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].url", is(video.getUrl())));
        
    }
    
}