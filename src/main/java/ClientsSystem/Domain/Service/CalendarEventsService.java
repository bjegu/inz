package ClientsSystem.Domain.Service;

import ClientsSystem.Domain.Model.CalendarEvents;
import ClientsSystem.Domain.Repository.CalendatEventsRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CalendarEventsService {

    @Autowired
    private CalendatEventsRepositoryI calendatEventsRepository;


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
        return calendatEventsRepository.save(calendarEvents);
    }
}
