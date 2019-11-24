package lukuvinkkikirjasto.controller;

import java.util.List;
import lukuvinkkikirjasto.entity.Kirja;
import lukuvinkkikirjasto.service.KirjaService;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author salojuur
 */
@RestController
public class KirjaController {
    
    @Autowired
    private KirjaService kirjaService;

//    @GetMapping("/")
//    @ResponseBody
//    public String test() {
//        return "Hello, world!";
//    }
    
    /** Add new book
     * @param kirjoittaja book author
     * @param otsikko headline or book name
     */
    @GetMapping("post/kirja/{kirjoittaja}/{otsikko}")
    @ResponseBody
    public String addBook(@PathVariable String kirjoittaja, @PathVariable String otsikko) {
        kirjaService.tallennaKirja(kirjoittaja, otsikko);
        return "lisätty: \nkirjoittaja: " + kirjoittaja + "\notsikko: " +otsikko;
    }
    
    /** fetch a book by id
     * @param id database id
     */
    @GetMapping("/get/kirja/{id}")
    @ResponseBody
    public String getBookById(@PathVariable int id) {
        List<Kirja> kirjat = kirjaService.haeKirjat();
        if (kirjat==null) {
            return "ei kirjoja";
        }
        return "kirjoittaja: " + kirjat.get(id).getKirjoittaja() + "\notsikko: " +kirjat.get(id).getOtsikko();
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<Kirja>> getBooks() {
      List<Kirja> kirjat = kirjaService.haeKirjat();
      if(kirjat == null || kirjat.size() == 0) {
        return ResponseEntity.notFound().build();
      }

      return ResponseEntity.ok(kirjat);
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity postOne(@RequestBody Kirja kirja) {
      kirjaService.tallennaKirja(kirja.getKirjoittaja(), kirja.getOtsikko());
      return ResponseEntity.ok(kirja);
    }
    
}
