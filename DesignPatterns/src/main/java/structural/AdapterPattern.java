package structural;

import java.util.List;

public class AdapterPattern {
    public static void main(String[] args) {
        List<NotificationSender> notificationSender = List.of( new EmailNotificationAdapter( new LegacyEmailSender()),
                new SlackNotificationAdapter( new SlackNotifier()));
        for( NotificationSender sender: notificationSender ){
            sender.sendNotification( "Boom : Money is in the Bank. ");
        }
    }
}


interface NotificationSender {
    void sendNotification(String message);
}



class LegacyEmailSender {
    public void sendEmail(String to, String content) {
        System.out.println("Sending EMAIL to " + to + ": " + content);
    }
}

class SlackNotifier {
    public void postMessageToChannel(String channelId, String message) {
        System.out.println("Posting to SLACK #" + channelId + ": " + message);
    }
}

class SmsService {
    public void pushSms(String phoneNumber, String text) {
        System.out.println("Sending SMS to " + phoneNumber + ": " + text);
    }
}

class EmailNotificationAdapter implements NotificationSender {
    private LegacyEmailSender emailSender;

    public EmailNotificationAdapter(LegacyEmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendNotification(String message) {
        emailSender.sendEmail("kuldeep@yourdomain.com", message);
    }
}

class SlackNotificationAdapter implements NotificationSender {
    private SlackNotifier slackNotifier;

    public SlackNotificationAdapter(SlackNotifier slackNotifier) {
        this.slackNotifier = slackNotifier;
    }

    public void sendNotification(String message) {
        slackNotifier.postMessageToChannel("dev-updates", message);
    }
}

