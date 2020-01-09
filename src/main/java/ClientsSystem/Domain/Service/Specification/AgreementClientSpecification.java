package ClientsSystem.Domain.Service.Specification;

import ClientsSystem.Domain.Model.Agreement;
import ClientsSystem.Domain.Model.Client;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
public class AgreementClientSpecification implements Specification<Agreement> {

    private final String clientEmail;

    @Override
    public Predicate toPredicate(Root<Agreement> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get("client").get("email"), clientEmail);
    }
}
