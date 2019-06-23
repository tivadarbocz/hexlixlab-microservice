package hu.helixlab.ms.entity.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    private String barCode;
}
