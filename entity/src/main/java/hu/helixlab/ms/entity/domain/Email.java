package hu.helixlab.ms.entity.domain;

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
}
