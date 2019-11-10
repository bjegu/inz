package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.EventClients;
import ClientsSystem.Domain.Service.EventClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/eventclients")
public class EventClientsController {

    @Autowired
    public EventClientsService eventClientsService;

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
