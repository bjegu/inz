package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.Client;
import ClientsSystem.Domain.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    // dependency injection annotation
    //ClientRepository injection
    @Autowired
    public ClientService clientService;

    @GetMapping("/")
    public Page<Client> showAll(){
        return clientService.findAll(PageRequest.of(0,2));
    }

    @PostMapping("/addmodify")
    public Client addEdit(@RequestBody() Client client){
//        client.getAddress().forEach(address -> address.setClient(client));
        return clientService.save(client);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCl(@PathVariable()UUID id){
        clientService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Client byId(@PathVariable()UUID id) {
        return clientService.findById(id);

    }

}
