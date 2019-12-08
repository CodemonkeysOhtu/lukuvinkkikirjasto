package lukuvinkkikirjasto.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Blogpost entity, inherits superclass Bookmark
 * @author salojuur
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class Blogpost extends Bookmark implements Serializable {
    
    @Column(name = "url")
    private String url;

    @Column(name = "tagit")
    @ElementCollection
    private List<String> tagit;

    @Column(name = "relatedCourses")
    @ElementCollection
    private List<String> relatedCourses;
    
}
