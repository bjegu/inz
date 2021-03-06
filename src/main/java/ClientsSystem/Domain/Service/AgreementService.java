package ClientsSystem.Domain.Service;

import ClientsSystem.Domain.Model.Agreement;
import ClientsSystem.Domain.Repository.AgreementRepositoryI;
import ClientsSystem.Infrastructure.notification.NotificationQueues;
import ClientsSystem.Infrastructure.notification.NotificationService;
import ClientsSystem.Domain.Service.Specification.AgreementClientSpecification;
import ClientsSystem.Domain.Service.Specification.AgreementSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AgreementService {

    @Autowired
    private AgreementRepositoryI agreementRepository;

    @Autowired
    private NotificationService notificationService;

    @Transactional
    public Page<Agreement> findAll(PageRequest pageRequest, String search) {
        Specification<Agreement> specification = search== null? null:new AgreementSpecification(search);
        return agreementRepository.findAll(specification, pageRequest);
    }

    @Transactional
    public Agreement save(Agreement agreement) {
        final Agreement response = agreementRepository.save(agreement);
        notificationService.sendNotification(response.getUuid(),
                response.getClient().getName() + ' ' + response.getClient().getSurname(),
                response.getClient().getEmail(),
                response.getEnd(),
                NotificationQueues.CLIENT_AGREEMENT);
        return response;
    }

    @Transactional
    public void deleteById(UUID id) {
        agreementRepository.deleteById(id);
        notificationService.sendNotificationDeactivation(id);
    }

    public Page<Agreement> getByClient(String userEmail, PageRequest pageRequest) {
        Specification<Agreement> specification = new AgreementClientSpecification(userEmail);
        return agreementRepository.findAll(specification, pageRequest);
    }

    public List<Agreement> searchAgreement(String search){
        Specification<Agreement> specification = new AgreementSpecification(search);
        return agreementRepository.findAll(specification);
    }

}
