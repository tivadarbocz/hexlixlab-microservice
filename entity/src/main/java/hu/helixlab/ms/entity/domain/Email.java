package hu.helixlab.ms.entity.domain;

import hu.helixlab.ms.entity.enumeration.EmailStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "emails", schema = "public")
@Getter
@Setter
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "email_generator")
    @SequenceGenerator(name = "email_generator",
            sequenceName = "email_seq")
    private Long id;

    @javax.validation.constraints.Email
    private String senderEmail;

    private String recipientEmail;

    private String subject;

    private String text;

    @Enumerated(EnumType.STRING)
    private EmailStatus emailStatus;
}
