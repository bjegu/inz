package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.Client;
import ClientsSystem.Domain.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static ClientsSystem.Infrastructure.security.SecurityUtils.*;

@RestController
@RequestMapping("/api/client")
@PreAuthorize(HAS_ADMIN_PERMISSION)
public class ClientController {

    public static final Integer CLIENT_PAGE_SIZE = 10;

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public Page<Client> showAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                @RequestParam(required = false, defaultValue = "surname") String sort,
                                @RequestParam(required = false, defaultValue = "ASC") String order,
                                @RequestParam(required = false) String search) {
        return clientService.findAll(preparePageRequest(page, order, sort), search);
    }

    private PageRequest preparePageRequest(Integer page, String order, String sort) {
        if (page == -1) {
            return PageRequest.of(0, 9999, Sort.by(Sort.Direction.fromString(order), sort));
        }
        return PageRequest.of(page, CLIENT_PAGE_SIZE, Sort.by(Sort.Direction.fromString(order), sort));
    }

    @GetMapping("/search")
    public List<Client> showAll(@RequestParam String search) {
        return clientService.searchClient(search);
    }

    @PostMapping("/")
    public Client addEdit(@RequestBody() Client client) {
//        client.getAddress().forEach(address -> address.setClient(client));
        return clientService.save(client);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCl(@PathVariable() UUID id) {
        clientService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Client byId(@PathVariable() UUID id) {
        return clientService.findById(id);

    }

}
