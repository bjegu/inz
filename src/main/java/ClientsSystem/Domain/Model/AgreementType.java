package ClientsSystem.Domain.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "agreement_type")
@ToString(exclude = "agreement")
@EqualsAndHashCode(exclude = "agreement")
public class AgreementType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="agreement_name")
    private String agrName;

    @Column(name="is_Repeatable")
    private Boolean repeatable;

    @Column(name="is_obligatory")
    private Boolean obligatory;

    @OneToMany(mappedBy="agreementType")
//    @JsonManagedReference(value="agreement_type")
    @JsonIgnore
    private List<Agreement> agreement;

}
