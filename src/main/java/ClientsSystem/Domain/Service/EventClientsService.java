package ClientsSystem.Domain.Service;

import ClientsSystem.Domain.Model.EventClients;
import ClientsSystem.Domain.Repository.EventClientsRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class EventClientsService {

    @Autowired
    private EventClientsRepositoryI eventClientsRepository;

    @Transactional
    public Page<EventClients> findAll(PageRequest of) {
        return eventClientsRepository.findAll(of);
    }

    @Transactional
    public EventClients save(EventClients eventClients) {
        return eventClientsRepository.save(eventClients);
    }

}
