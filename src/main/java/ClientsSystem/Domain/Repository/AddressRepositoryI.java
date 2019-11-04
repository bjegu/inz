package ClientsSystem.Domain.Repository;

import ClientsSystem.Domain.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepositoryI extends JpaRepository<Address, UUID> {
}
