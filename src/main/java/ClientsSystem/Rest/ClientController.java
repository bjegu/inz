package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.Client;
import ClientsSystem.Domain.Repository.ClientRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    // dependency injection annotation
    //ClientRepository injection
    @Autowired
    public ClientRepositoryI clientRepository;

    @GetMapping("/")
    public Page<Client> showAll(){
        return clientRepository.findAll(PageRequest.of(0,2));
    }

    @PostMapping("/")
    public Client addEdit(@RequestBody() Client client){
        return clientRepository.save(client);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCl(@PathVariable()UUID id){
        clientRepository.deleteById(id);
    }

}
