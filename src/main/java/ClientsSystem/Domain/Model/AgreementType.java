package ClientsSystem.Domain.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "agreement_type")
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

    @OneToOne(mappedBy="agreementType")
    private Agreement agreement;

}
