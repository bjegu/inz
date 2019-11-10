package ClientsSystem.Domain.Service;

import ClientsSystem.Domain.Model.AgreementType;
import ClientsSystem.Domain.Repository.AgreementTypeRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgreementTypeService {

    @Autowired
    private AgreementTypeRepositoryI agreementTypeRepository;

    @Transactional
    public Page<AgreementType> findAll(PageRequest of) {
        return agreementTypeRepository.findAll(of);
    }

    @Transactional
    public AgreementType save(AgreementType agreementType) {
        return agreementTypeRepository.save(agreementType);
    }




}
