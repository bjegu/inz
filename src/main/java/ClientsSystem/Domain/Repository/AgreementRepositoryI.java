package ClientsSystem.Domain.Repository;

import ClientsSystem.Domain.Model.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface AgreementRepositoryI extends JpaRepository<Agreement, UUID>, JpaSpecificationExecutor<Agreement> {
}
