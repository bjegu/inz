package ClientsSystem.Domain.Service.Validator;

import ClientsSystem.Domain.Model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ClientValidationException extends RuntimeException {
Client client;

public ClientValidationException(Client client, String message){
    super(message);
    this.client = client;
}
}
