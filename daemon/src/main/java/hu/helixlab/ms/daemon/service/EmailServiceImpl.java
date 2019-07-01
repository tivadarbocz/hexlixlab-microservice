package hu.helixlab.ms.daemon.service;

import hu.helixlab.ms.entity.domain.Email;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void send(Email email) {
        //TODO
        /*SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("");
        message.setSubject("");
        message.setText("");
        javaMailSender.send(message);*/
    }

    @Override
    public List<Email> findAllSendable() {
        //TODO
        return null;
    }
}
