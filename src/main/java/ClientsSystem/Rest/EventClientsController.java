package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.EventClients;
import ClientsSystem.Domain.Service.EventClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static ClientsSystem.Infrastructure.security.SecurityUtils.HAS_ADMIN_PERMISSION;

@RestController
@RequestMapping("/api/eventclients")
@PreAuthorize(HAS_ADMIN_PERMISSION)
public class EventClientsController {

    @Autowired
    private EventClientsService eventClientsService;

    @GetMapping("/")
    public Page<EventClients> showAll(){
        return eventClientsService.findAll(PageRequest.of(0,10));
    }

    @PostMapping("/addmodify")
    public EventClients addEdit(@RequestBody() EventClients eventClients){
        return eventClientsService.save(eventClients);
    }

    //TODO find by id???
}
