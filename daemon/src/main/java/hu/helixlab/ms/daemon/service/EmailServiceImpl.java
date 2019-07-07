package hu.helixlab.ms.daemon.service;

import hu.helixlab.ms.dao.repository.EmailRepository;
import hu.helixlab.ms.entity.domain.Email;
import hu.helixlab.ms.entity.enumeration.EmailStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final EmailRepository emailRepository;

    public EmailServiceImpl(JavaMailSender javaMailSender, EmailRepository emailRepository) {
        this.javaMailSender = javaMailSender;
        this.emailRepository = emailRepository;
    }

    @Override
    public void send(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getRecipientEmail());
        message.setSubject(email.getSubject());
        message.setText(email.getText());
        javaMailSender.send(message);
    }

    @Override
    public List<Email> findAllSendable() {
        return emailRepository.findAllEmailByNotLikeStatus(EmailStatus.DELIVERED.name());
    }

    @Override
    public Email save(Email email) {
        return emailRepository.save(email);
    }
}
