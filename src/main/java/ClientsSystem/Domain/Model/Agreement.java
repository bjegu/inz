package ClientsSystem.Domain.Model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.type.DateType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
public class Agreement implements Serializable {

    //relation with a client to be added later

    @Id
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name="agr_id", updatable = false, nullable = false)
    private UUID uuid;

    @Column(nullable = false,name="agreement_no")
    private String agreementNo;

    @Column(nullable = false, name = "agreement_type_id")
    private Integer agrTypeId;
    //relation one to one later

    @Column(nullable = false, name="start_date")
    private DateType start;

    @Column(name="finish_date")
    private DateType end;

    @Column(nullable = false, name="is_active_flg")
    private Boolean active;
    // flag should be assigned automatically later

    @Column(name="additional_info")
    private String additional;
}
