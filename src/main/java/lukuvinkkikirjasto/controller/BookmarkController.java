package lukuvinkkikirjasto.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lukuvinkkikirjasto.entity.Article;
import lukuvinkkikirjasto.entity.Blogpost;
import lukuvinkkikirjasto.entity.Book;
import lukuvinkkikirjasto.entity.Bookmark;
import lukuvinkkikirjasto.entity.Video;
import lukuvinkkikirjasto.service.ArticleService;
import lukuvinkkikirjasto.service.BlogpostService;
import lukuvinkkikirjasto.service.BookService;
import lukuvinkkikirjasto.service.VideoService;

@RestController
public class BookmarkController {

  @Autowired
  private ArticleService as;
  @Autowired
  private BookService bs;
  @Autowired
  private BlogpostService bps;
  @Autowired
  private VideoService vs;
  @Autowired
  private Gson gson;
  

  //TODO: kannattaa varmaan siivota
  @GetMapping(value = "/", produces = "application/json")
  @ResponseBody
  public String getAll() {
    List<Article> allArticles = as.getArticles();
    List<Book> allBooks = bs.getBooks();
    List<Blogpost> allBlogposts = bps.getBlogposts();
    List<Video> allVideos = vs.getVideos();

    String articles = "{ \"articles\": " + gson.toJson(allArticles);
    String books = ", \"books\": " + gson.toJson(allBooks);
    String blogposts = ", \"blogposts\": " + gson.toJson(allBlogposts);
    String videos = ", \"videos\": " + gson.toJson(allVideos);

    return articles + books + blogposts + videos + " }";
  }

}