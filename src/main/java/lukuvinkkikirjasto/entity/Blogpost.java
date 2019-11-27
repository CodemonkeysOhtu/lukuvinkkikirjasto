package lukuvinkkikirjasto.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Blogpost entity, inherits superclass Bookmark
 * @author salojuur
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blogpost extends Bookmark implements Serializable {
    
    @Column(name = "url")
    private String url;
    
}
