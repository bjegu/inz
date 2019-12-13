package ClientsSystem.Domain.Service.Specification;

import ClientsSystem.Domain.Model.Client;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ClientSpecification implements Specification<Client> {

    private final String criteria;

    public ClientSpecification(String criteria){
        this.criteria="%"+criteria+"%";
    }

    @Override
    public Predicate toPredicate(Root<Client> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate predicateSurname = criteriaBuilder.like(root.get("surname"), criteria);
        Predicate predicateName = criteriaBuilder.like(root.get("name"), criteria);
        Predicate predicatePesel = criteriaBuilder.like(root.get("pesel").as(String.class), criteria);
        Predicate predicatePhone = criteriaBuilder.like(root.get("phone").as(String.class), criteria);
        Predicate predicateRegon = criteriaBuilder.like(root.get("regon").as(String.class), criteria);
        Predicate predicateCompName = criteriaBuilder.like(root.get("compName"), criteria);

        return criteriaBuilder.or(predicateSurname, predicateName,predicatePesel, predicatePhone, predicateRegon, predicateCompName);
    }
}
