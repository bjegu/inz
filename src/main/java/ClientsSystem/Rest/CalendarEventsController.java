package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.CalendarEvents;
import ClientsSystem.Domain.Repository.CalendatEventsRepositoryI;
import ClientsSystem.Domain.Service.CalendarEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/calendarevents")
public class CalendarEventsController {

    @Autowired
    public CalendarEventsService calendarEventsService;

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
}
