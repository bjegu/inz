package ClientsSystem.Domain.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Entity
@Data
@ToString(exclude = {"client"})
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
    @JsonBackReference(value="client_clevents")
    private Client client;


    @ManyToOne()
    @Id
    @JoinColumn(name="event_id")
    @Type(type="uuid-char")
    @NotNull
    @JsonBackReference(value = "calendar_clevents")
    private CalendarEvents calendarEvents;
}
