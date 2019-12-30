package ClientsSystem.Domain.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"eventClients", "eventType"})
@Table(name="calendar_events")
public class CalendarEvents implements Serializable {

    @Id
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(
            name = "uuid",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="event_id", updatable = false, nullable = false)
    private UUID uuid;

    @Column(name="start_date")
    @NotNull
    private LocalDateTime start;

    @Column(name="finish_date")
    @NotNull
    private LocalDateTime finish;

    @Column
    private String description;

    @Column(name="event_name")
    @NotNull
    private String name;

    @OneToMany(mappedBy = "calendarEvents", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "calendar_clevents")
    private Set<EventClients> eventClients;

    @ManyToOne
    @JoinColumn(name = "event_type", nullable = false)
//    @JsonBackReference(value="event_type")
    private EventType eventType;
}
