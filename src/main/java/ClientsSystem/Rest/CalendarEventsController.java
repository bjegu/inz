package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.CalendarEvents;
import ClientsSystem.Domain.Model.EventType;
import ClientsSystem.Domain.Repository.CalendatEventsRepositoryI;
import ClientsSystem.Domain.Repository.EventTypeRepositoryI;
import ClientsSystem.Domain.Service.CalendarEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static ClientsSystem.Infrastructure.security.SecurityUtils.HAS_ADMIN_PERMISSION;

@RestController
@PreAuthorize(HAS_ADMIN_PERMISSION)
@RequestMapping("api/calendar")
public class CalendarEventsController {

    @Autowired
    private CalendarEventsService calendarEventsService;

    @GetMapping
    public Page<CalendarEvents> showAll(){
        return calendarEventsService.findAll(PageRequest.of(0,10));
    }

    @PostMapping
    public CalendarEvents addModify(@RequestBody() CalendarEvents calendarEvents){
        return calendarEventsService.save(calendarEvents);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMeeting(@PathVariable() UUID id){
        calendarEventsService.deleteById(id);
    }

    @GetMapping("{year}/{month}")
    public List<CalendarEvents> showByDate(@PathVariable() Integer year, @PathVariable() Integer month){
        return calendarEventsService.findAll(PageRequest.of(0,999)).getContent();
    }

    @GetMapping("/type")
    public List<EventType> showTypes(){
        return calendarEventsService.getTypes();
    }
}
