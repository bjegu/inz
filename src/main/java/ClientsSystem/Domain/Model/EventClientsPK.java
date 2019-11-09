package ClientsSystem.Domain.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
public class EventClientsPK implements Serializable {

    private String name;
    private UUID calendarEvents;
    
}
