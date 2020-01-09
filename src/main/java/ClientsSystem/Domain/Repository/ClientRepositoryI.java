package ClientsSystem.Domain.Repository;

import ClientsSystem.Domain.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepositoryI extends JpaRepository<Client, UUID>, JpaSpecificationExecutor<Client> {

    @Query("SELECT c from Client c where email = :email")
    Optional<Client> findByEmail(@Param("email") String email);

}
