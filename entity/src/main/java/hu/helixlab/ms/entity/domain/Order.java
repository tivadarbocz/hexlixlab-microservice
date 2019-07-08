package hu.helixlab.ms.entity.domain;


import hu.helixlab.ms.entity.enumeration.OrderStatus;
import hu.helixlab.ms.entity.enumeration.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders", schema = "public")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "order_generator")
    @SequenceGenerator(name = "order_generator",
            sequenceName = "order_seq")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @OneToOne
    @JoinColumn(name = "delivery_info_id", referencedColumnName = "id")
    private DeliveryInfo deliveryInfo;
}
