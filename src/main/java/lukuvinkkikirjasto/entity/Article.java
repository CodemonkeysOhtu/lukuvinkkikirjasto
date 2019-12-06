package lukuvinkkikirjasto.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
public class Article extends Bookmark implements Serializable {
    
    @Column(name = "localDate")
    private LocalDate localDate;
    
    @Column(name = "publisher")
    private String publisher;
    
    @Column(name = "tagit")
    @ElementCollection
    private List<String> tagit;

    @Column(name = "related")
    @ElementCollection
    private List<String> related;
    
}
