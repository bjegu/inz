package ClientsSystem.Domain.Repository;

import ClientsSystem.Domain.Model.AgreementType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementTypeRepositoryI extends JpaRepository<AgreementType, Integer> {
}
