package ClientsSystem.Domain.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="event_type")
@ToString(exclude = "calendarEvents")
@EqualsAndHashCode(exclude = "calendarEvents")
public class EventType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="event_type_name")
    private String eventTypeName;

    @OneToMany(mappedBy="eventType")
    @JsonIgnore
//    @JsonManagedReference(value="event_type")
    private List<CalendarEvents> calendarEvents;
}
