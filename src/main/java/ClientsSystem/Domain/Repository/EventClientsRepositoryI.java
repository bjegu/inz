package ClientsSystem.Domain.Repository;

import ClientsSystem.Domain.Model.EventClients;
import ClientsSystem.Domain.Model.EventClientsPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventClientsRepositoryI extends JpaRepository<EventClients, EventClientsPK> {
}
