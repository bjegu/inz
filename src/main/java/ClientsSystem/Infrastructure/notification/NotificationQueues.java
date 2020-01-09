package ClientsSystem.Infrastructure.notification;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum NotificationQueues {

    CLIENT_AGREEMENT,
    EVENT_REMINDER,
    DEACTIVATION;

    static List<String> getStringList(){
        return Arrays.stream(NotificationQueues.values()).map(NotificationQueues::toString).collect(Collectors.toList());
    }

}
