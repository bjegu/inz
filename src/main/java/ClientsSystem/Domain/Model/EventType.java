package ClientsSystem.Domain.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="event_type")
public class EventType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="event_type_name")
    private String eventTypeName;

    @OneToOne(mappedBy="eventType")
    private CalendarEvents calendarEvents;
}
