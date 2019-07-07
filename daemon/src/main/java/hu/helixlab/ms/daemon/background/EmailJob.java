package hu.helixlab.ms.daemon.background;

import hu.helixlab.ms.daemon.service.EmailService;
import hu.helixlab.ms.entity.domain.Email;
import hu.helixlab.ms.entity.enumeration.EmailStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class EmailJob {

    private final EmailService emailService;

    public EmailJob(EmailService emailService) {
        this.emailService = emailService;
    }

    @Scheduled(cron = "*/10 * * * * *")
    private void send() {

        //TODO Locks? Duplicate sending? Maybe later...
        List<Email> emails = emailService.findAllSendable();

        if (!CollectionUtils.isEmpty(emails)) {
            emails.forEach(e -> {
                try {
                    emailService.send(e);
                    e.setEmailStatus(EmailStatus.DELIVERED);
                } catch (Exception ex) {
                    e.setEmailStatus(EmailStatus.FAILED);
                } finally {
                    emailService.save(e);
                }
            });
        }
    }
}
