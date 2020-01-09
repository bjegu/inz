package ClientsSystem.Infrastructure.notification;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class NotificationService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendNotification(UUID id, String addressee, String email, LocalDateTime dateTime, NotificationQueues queue) {
        sendMessage(NotificationMessageDTO.builder()
                        .id(id.toString())
                        .addressee(addressee)
                        .sendTo(email)
                        .dateTime(Timestamp.valueOf(dateTime)).build(),
                queue);
    }
    public void sendNotification(UUID id, String addressee, String email, LocalDate date, NotificationQueues queue) {
        sendNotification(id, addressee, email, date.atStartOfDay(), queue);
    }

    public void sendNotificationDeactivation(UUID id) {
        sendMessage(NotificationMessageDTO.builder().id(id.toString()).build(),
                NotificationQueues.DEACTIVATION);
    }

    private void sendMessage(NotificationMessageDTO message, NotificationQueues queue) {
        System.out.println(queue + ": Sending Notification Message " + message);
        rabbitTemplate.convertAndSend(queue.toString(), message);
    }
}
