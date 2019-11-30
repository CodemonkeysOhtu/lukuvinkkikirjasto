package lukuvinkkikirjasto.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Video entity, inherits superclass Bookmark
 * @author salojuur
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class Video extends Bookmark implements Serializable {
    
    @Column(name = "url")
    private String url;
    
    @Column(name = "comment")
    private String comment;

    @Column(name = "relatedCourses")
    private String relatedCourses;
    
}
