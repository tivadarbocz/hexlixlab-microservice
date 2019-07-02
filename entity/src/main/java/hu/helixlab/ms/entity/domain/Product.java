package hu.helixlab.ms.entity.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "products", schema = "public")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_generator")
    @SequenceGenerator(name = "product_generator",
            sequenceName = "product_seq")
    private Long id;
    private String description;
    private String name;
    private String imgPath;
}
