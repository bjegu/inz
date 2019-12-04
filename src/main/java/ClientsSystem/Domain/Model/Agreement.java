package ClientsSystem.Domain.Model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@ToString(exclude = {"client"})
@Embeddable
public class Agreement implements Serializable {

    @Id
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name="agr_id", updatable = false, nullable = false)
    private UUID uuid;

    @ManyToOne()
    @JoinColumn(name = "client_id")
    @NotNull
    @JsonBackReference(value ="client_agreement")
    private Client client;

    @Column(nullable = false,name="agreement_no")
    private String agreementNo;


    @Column(nullable = false, name="start_date")
    private LocalDate start;

    @Column(name="finish_date")
    private LocalDate end;

    @Column(nullable = false, name="is_active_flg")
    private Boolean active;
    // flag should be assigned automatically later

    @Column(name="additional_info")
    private String additional;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agreement_type_id", referencedColumnName = "id")
    private AgreementType agreementType;

}
