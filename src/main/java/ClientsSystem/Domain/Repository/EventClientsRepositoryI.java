package ClientsSystem.Domain.Repository;

import ClientsSystem.Domain.Model.EventClients;
import ClientsSystem.Domain.Model.EventClientsPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface EventClientsRepositoryI extends JpaRepository<EventClients, EventClientsPK> {

    @Modifying
    @Query(("DELETE EventClients ec WHERE ec.calendarEvents.uuid = :id"))
    public void removeByEventId(@Param("id") UUID id);
}
