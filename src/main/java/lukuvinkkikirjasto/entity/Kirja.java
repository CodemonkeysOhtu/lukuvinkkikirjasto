package lukuvinkkikirjasto.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author salojuur
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "KIRJA")
public class Kirja extends AbstractPersistable<Long> {
    
    private String kirjoittaja;
    
    private String otsikko;
    
}
