package lukuvinkkikirjasto.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Article entity, inherits superclass Bookmark
 * @author salojuur
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class Book extends Bookmark implements Serializable {

    @Column(name = "isbn")
    private String isbn;
    
    @Column(name = "year")
    private int year;
    
    @Column(name = "edition")
    private String edition;

    @Column(name = "tagit")
    private String tagit;
    
    @Column(name = "related")
    private String related;

    
}
