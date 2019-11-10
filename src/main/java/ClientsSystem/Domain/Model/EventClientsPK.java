package ClientsSystem.Domain.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventClientsPK implements Serializable {

    private String name;

    @Type(type="uuid-char")
    private UUID calendarEvents;
    
}
