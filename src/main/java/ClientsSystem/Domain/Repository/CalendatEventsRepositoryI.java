package ClientsSystem.Domain.Repository;

import ClientsSystem.Domain.Model.CalendarEvents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CalendatEventsRepositoryI extends JpaRepository<CalendarEvents, UUID> {
}
