package ClientsSystem.Domain.Service;

import ClientsSystem.Domain.Model.Client;
import ClientsSystem.Domain.Repository.ClientRepositoryI;
import ClientsSystem.Domain.Service.Validator.ClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.UUID;

@Service
public class ClientService {

    //validation of individual/ bussiness client


    @Autowired
    private ClientRepositoryI clientRepository;

    @Transactional
    public Page<Client> findAll(PageRequest pageRequest) {
        return clientRepository.findAll(pageRequest);
    }

    @Transactional
    public Client save(Client client) {
        ClientValidator.validateClient(client);
        return clientRepository.save(client);
    }

    @Transactional
    public void deleteById(UUID id) {
        clientRepository.deleteById(id);
    }

    //OR ELSE (null)
    @Transactional
    public Client findById(UUID id) {
       return clientRepository.findById(id).orElse(null);
    }

}
