package lukuvinkkikirjasto.controller;

import java.util.List;
import lukuvinkkikirjasto.entity.Video;
import lukuvinkkikirjasto.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class VideoController {
    
    @Autowired
    private VideoService videoService;
    
    @RequestMapping(value = "/videos", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<Video>> getVideos() {
      List<Video> videos = videoService.getVideos();
      if(videos == null || videos.isEmpty()) {
        return ResponseEntity.ok(videos);
      }
      return ResponseEntity.ok(videos);
    }

    @RequestMapping(value = "/videos", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity postOneBlogpost(@RequestBody Video video) {
      videoService.saveVideo(video.getAuthor(), video.getTitle(), video.getUrl(), video.getComment());
      return ResponseEntity.ok(video);
    }
}
