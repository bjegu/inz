package ClientsSystem.Domain.Repository;

import ClientsSystem.Domain.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepositoryI extends JpaRepository<Client, Integer> {
    @Query("SELECT c from Client c where id = :clientId")
    Optional<Client> findById(@Param("clientId") UUID clientId);

}