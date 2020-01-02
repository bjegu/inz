package ClientsSystem.Domain.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Data
@ToString(exclude = {"calendarEvents"})
@EqualsAndHashCode(exclude = {"calendarEvents", "client"})
@IdClass(EventClientsPK.class)
@Table(name="event_client")
public class EventClients {

    @Id
    private String name;

//    @Id
////    @Type(type="uuid-char")
////    @GeneratedValue(generator = "uuid")
////    @GenericGenerator(
////            name = "uuid",
////            strategy = "org.hibernate.id.UUIDGenerator")
////    @Column(name="event_id")
////    private UUID uuid;

    @Column
    private Integer phone;

    @ManyToOne()
    @JoinColumn(name = "client_id")
//    @JsonBackReference(value="client_events")
    private Client client;


    @ManyToOne()
    @JoinColumn(name="event_id")
    @Type(type="uuid-char")
    @Id
    @NotNull
    //@JsonBackReference(value = "calendar_clevents")
    @JsonIgnore
    private CalendarEvents calendarEvents;
}
