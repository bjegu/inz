package ClientsSystem.Domain.Service;

import ClientsSystem.Domain.Model.Agreement;
import ClientsSystem.Domain.Repository.AgreementRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AgreementService {

    @Autowired
    private AgreementRepositoryI agreementRepository;

    @Transactional
    public Page<Agreement> findAll(PageRequest of) {
        return agreementRepository.findAll(of);
    }

    @Transactional
    public Agreement save(Agreement agreement) {
        return agreementRepository.save(agreement);
    }

    @Transactional
    public void deleteById(UUID id) {
        agreementRepository.deleteById(id);
    }
}
