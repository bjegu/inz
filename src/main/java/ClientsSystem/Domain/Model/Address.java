package ClientsSystem.Domain.Model;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@ToString(exclude = {"client"})
public class Address implements Serializable {

    @Id
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name="address_id", updatable = false, nullable = false)
    private UUID uuid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;

    @Column(name="address_type", nullable = false)
    private String addressType;

    @Column(nullable = false)
    private String street;

    @Column(name="house_no", nullable = false)
    private Integer houseNumber;

    @Column(name="local_no")
    private Integer localNumber;

    @Column(name="postal_code", nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String city;
}
