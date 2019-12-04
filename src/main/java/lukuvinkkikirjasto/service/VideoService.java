package lukuvinkkikirjasto.service;

import java.util.List;
import lukuvinkkikirjasto.entity.Video;
import lukuvinkkikirjasto.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    
    @Autowired
    private VideoRepository videoRepository;
    
    /** save video in database */
    public Video saveVideo(String author, String title, String url, String comment, List<String> relatedCourses) {
        
        Video video = new Video();
        video.setAuthor(author);
        video.setTitle(title);
        video.setUrl(url);
        video.setComment(comment);
        video.setRelatedCourses(relatedCourses);
        video.setType("video");
        return videoRepository.save(video);
        
    }

    public Video saveVideo(Video video) {
        video.setType("video");
        return videoRepository.save(video);
    }
    
    /** fetch all videos from database */
    public List<Video> getVideos() {
        return videoRepository.findAll();
    }
    
    /** fetch a video by id from database */
    public Video getBlogpost(Long id) {
        return videoRepository.getOne(id);
    }
    
}
