package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.Client;
import ClientsSystem.Domain.Service.ClientService;
import ClientsSystem.Domain.Service.Specification.ClientSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    public final Integer CLIENT_PAGE_SIZE = 10;

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public List<Client> showAll(@RequestParam (required = false, defaultValue = "surname") String sort,
                                @RequestParam (required = false, defaultValue = "ASC") String order,
                                @RequestParam(required = false) String search){
        return clientService.findAll(PageRequest.of(0,CLIENT_PAGE_SIZE, Sort.by(Sort.Direction.fromString(order), sort)), search)
                .getContent();
    }

    @GetMapping("/search")
    public List<Client> showAll(@RequestParam String search){
        return clientService.searchClient(search);
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
