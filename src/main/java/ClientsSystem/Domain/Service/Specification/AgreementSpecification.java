package ClientsSystem.Domain.Service.Specification;

import ClientsSystem.Domain.Model.Agreement;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AgreementSpecification implements Specification<Agreement> {

    private final String criteria;

    public AgreementSpecification(String criteria){
        this.criteria="%"+criteria+"%";
    }


    @Override
    public Predicate toPredicate(Root<Agreement> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate predicateAgreementNo = criteriaBuilder.like(root.get("agreementNo"),criteria);
        Predicate predicateName = criteriaBuilder.like(root.get("client").get("name"),criteria);
        Predicate predicateStart = criteriaBuilder.like(root.get("start").as(String.class),criteria);
        Predicate predicateEnd = criteriaBuilder.like(root.get("end").as(String.class),criteria);
        Predicate predicateAdd = criteriaBuilder.like(root.get("additional"),criteria);
        Predicate predicateType = criteriaBuilder.like(root.get("agreementType").get("agrName"),criteria);
        Predicate predicateSurname = criteriaBuilder.like(root.get("client").get("surname"),criteria);
        return criteriaBuilder.or(predicateAgreementNo,predicateName, predicateStart, predicateEnd, predicateAdd, predicateType, predicateSurname);
    }
}
