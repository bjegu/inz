package ClientsSystem.Domain.Service;

import ClientsSystem.Domain.Model.Agreement;
import ClientsSystem.Domain.Repository.AgreementRepositoryI;
import ClientsSystem.Infrastructure.notification.NotificationQueues;
import ClientsSystem.Infrastructure.notification.NotificationService;
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

    @Autowired
    private NotificationService notificationService;

    @Transactional
    public Page<Agreement> findAll(PageRequest of) {
        return agreementRepository.findAll(of);
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
}
