package ClientsSystem.Domain.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Client {

    @Id
    private UUID Id = UUID.randomUUID();



}
