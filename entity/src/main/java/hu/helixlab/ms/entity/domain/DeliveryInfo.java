package hu.helixlab.ms.entity.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "delivery_informations", schema = "public")
@Getter
@Setter
public class DeliveryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "delivery_info_generator")
    @SequenceGenerator(name = "delivery_info_generator",
            sequenceName = "delivery_info_seq")
    private Long id;

    private String senderAddress;

    private String recipientAddress;

    @Email
    private String senderEmail;

    @Email
    private String recipientEmail;

    @Column(length = 24)
    private String phone;

    @Column(length = 64)
    private String barCode;

    private String note;

    @OneToOne(mappedBy = "deliveryInfo")
    private Order order;
}
