package ClientsSystem.Domain.Repository;

import ClientsSystem.Domain.Model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepositoryI extends JpaRepository<EventType, Integer> {
}
