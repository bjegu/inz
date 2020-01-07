package ClientsSystem.Infrastructure.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@ToString
@AllArgsConstructor
@Builder
public class NotificationMessageDTO implements Serializable {

    private String id;
    private String addressee;
    private String sendTo;
    private Timestamp dateTime;

}
