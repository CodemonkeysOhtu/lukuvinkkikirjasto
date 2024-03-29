package lukuvinkkikirjasto.controller;

import java.util.List;
import lukuvinkkikirjasto.entity.Video;
import lukuvinkkikirjasto.service.VideoService;
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
    public ResponseEntity postOneVideo(@RequestBody Video video) {
      Video savedVideo = videoService.saveVideo(video.getAuthor(), video.getTitle(), video.getUrl(), video.getComment(), video.getRelatedCourses());
      return ResponseEntity.ok(savedVideo);
    }

    @DeleteMapping("/videos/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
      boolean response = videoService.deleteById(id);
      return response ?
          ResponseEntity.ok("Success!") :
          ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to delete object!");
    }
}
