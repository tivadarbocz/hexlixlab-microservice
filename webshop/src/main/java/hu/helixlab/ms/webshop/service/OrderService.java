package hu.helixlab.ms.webshop.service;

import hu.helixlab.ms.entity.domain.DeliveryInfo;
import hu.helixlab.ms.entity.domain.Order;

import java.util.List;

public interface OrderService {

    /**
     * TODO
     *
     * @return
     */
    List<Order> findAll();

    /**
     * TODO
     *
     * @param order
     * @return
     */
    Order createOrder(Order order);

    /**
     * TODO
     *
     * @param id
     * @return
     */
    Order findOne(long id);

    /**
     * TODO
     *
     * @param order
     * @return
     */
    Order update(Order order);

    /**
     * TODO
     *
     * @param id
     * @return
     */
    DeliveryInfo deleteById(long id);

    /**
     * TODO
     *
     * @return
     */
    DeliveryInfo createTestOrder();
}
