package ClientsSystem.Domain.Service;

import ClientsSystem.Domain.Model.CalendarEvents;
import ClientsSystem.Domain.Model.EventClients;
import ClientsSystem.Domain.Model.EventType;
import ClientsSystem.Domain.Repository.CalendatEventsRepositoryI;
import ClientsSystem.Domain.Repository.EventClientsRepositoryI;
import ClientsSystem.Domain.Repository.EventTypeRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class CalendarEventsService {

    @Autowired
    private CalendatEventsRepositoryI calendatEventsRepository;
    @Autowired
    private EventClientsRepositoryI eventClientsRepositoryI;
    @Autowired
    private EventTypeRepositoryI eventTypeRepositoryI;


    @Transactional
    public void deleteById(UUID id) {
        calendatEventsRepository.findById(id);
    }

    @Transactional
    public Page<CalendarEvents> findAll(PageRequest of) {
        return calendatEventsRepository.findAll(of);
    }

    @Transactional
    public CalendarEvents save(CalendarEvents calendarEvents) {
        if (calendarEvents.getUuid() == null) {
            Set<EventClients> eventClients = calendarEvents.getEventClients();
            calendarEvents.setEventClients(Collections.emptySet());
            CalendarEvents respond = calendatEventsRepository.save(calendarEvents);
            eventClients.forEach(eventClient -> eventClient.setCalendarEvents(respond));
            calendarEvents.setEventClients(eventClients);
        }else{
            eventClientsRepositoryI.removeByEventId(calendarEvents.getUuid());
            calendarEvents.getEventClients().forEach(eventClient -> eventClient.setCalendarEvents(calendarEvents));
        }
        return calendatEventsRepository.save(calendarEvents);
    }

    public List<EventType> getTypes() {
        return eventTypeRepositoryI.findAll();
    }
}
