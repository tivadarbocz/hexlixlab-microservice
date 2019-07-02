package hu.helixlab.ms.entity.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "order_items", schema = "public")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "order_item_generator")
    @SequenceGenerator(name = "order_item_generator",
            sequenceName = "order_item_seq")
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private Integer quantity;
}
