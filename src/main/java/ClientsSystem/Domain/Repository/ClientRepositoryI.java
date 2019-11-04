package ClientsSystem.Domain.Repository;

import ClientsSystem.Domain.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ClientRepositoryI extends JpaRepository<Client, UUID> {
//    @Query("SELECT c from Client c where id = :clientId")
//    Optional<Client> findById(@Param("clientId") UUID clientId);

}
