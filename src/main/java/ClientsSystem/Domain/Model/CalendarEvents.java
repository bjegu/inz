package ClientsSystem.Domain.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @JsonManagedReference
    private Set<EventClients> eventClients;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="event_type", referencedColumnName = "id")
    private EventType eventType;
}
