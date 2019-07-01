package hu.helixlab.ms.daemon.background;

import hu.helixlab.ms.daemon.service.EmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailJob {

    private final EmailService emailService;

    public EmailJob(EmailService emailService) {
        this.emailService = emailService;
    }

    @Scheduled(cron = "*/10 * * * * *")
    private void send() {
        emailService.send(null);
    }
}
