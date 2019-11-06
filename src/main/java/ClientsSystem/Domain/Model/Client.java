package ClientsSystem.Domain.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(exclude = {"address", "agreement"})
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {

    @Id
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="client_id", updatable = false, nullable = false)
    private UUID uuid;

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

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Address> address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Agreement> agreement;

}
