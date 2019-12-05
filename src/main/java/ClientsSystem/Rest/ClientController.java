package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.Client;
import ClientsSystem.Domain.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    // dependency injection annotation
    //ClientRepository injection
    @Autowired
    public ClientService clientService;

    @GetMapping("/")
    public List<Client> showAll(@RequestParam (required = false, defaultValue = "") String sort, @RequestParam (required = false, defaultValue = "ASC") String order){
        return clientService.findAll(PageRequest.of(0,10, Sort.by(Sort.Direction.fromString(order), sort)))
                .getContent();
    }

    @PostMapping("/")
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
