package lukuvinkkikirjasto.service;

import java.util.List;
import lukuvinkkikirjasto.entity.Kirja;
import lukuvinkkikirjasto.repository.KirjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author salojuur
 */
@Service
public class KirjaService {
    
    @Autowired
    private KirjaRepository kirjaRepository;
    
    /** save book in database */
    public void tallennaKirja(String kirjoittaja, String otsikko) {
        
        Kirja kirja = new Kirja();
        kirja.setKirjoittaja(kirjoittaja);
        kirja.setOtsikko(otsikko);
        kirjaRepository.save(kirja);
        
    }
    
    /** fetch all books from database */
    public List<Kirja> haeKirjat() {
        return kirjaRepository.findAll();
    }
    
    /** fetch a book by id from database */
    public Kirja haeKirja(Long id) {
        return kirjaRepository.getOne(id);
    }
    
    
}
