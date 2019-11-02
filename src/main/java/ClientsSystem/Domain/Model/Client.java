package ClientsSystem.Domain.Model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Client {

    @Id
    @Type(type="uuid-char")
    private UUID Id = UUID.randomUUID();

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private Long pesel;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Long phone;

    @Column(unique = true)
    private Long regon;

    @Column
    private String compName;

}
