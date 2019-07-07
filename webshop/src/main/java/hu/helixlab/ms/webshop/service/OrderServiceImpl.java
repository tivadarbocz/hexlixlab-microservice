package hu.helixlab.ms.webshop.service;

import hu.helixlab.ms.dao.repository.OrderRepository;
import hu.helixlab.ms.dao.repository.ProductRepository;
import hu.helixlab.ms.entity.domain.DeliveryInfo;
import hu.helixlab.ms.entity.domain.Order;
import hu.helixlab.ms.entity.domain.OrderItem;
import hu.helixlab.ms.entity.enumeration.OrderStatus;
import hu.helixlab.ms.entity.enumeration.PaymentStatus;
import hu.helixlab.ms.webshop.exception.NoResourceException;
import hu.helixlab.ms.webshop.exception.OrderException;
import hu.helixlab.ms.webshop.exception.PaymentException;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(Order order) {

        validateOrder(order);

        order.setPaymentStatus(PaymentStatus.WAITING);
        order.setOrderStatus(OrderStatus.CREATED);

        //TODO do something with deliveryInfo
        DeliveryInfo deliveryInfo = new DeliveryInfo();
        deliveryInfo.setOrder(order);


        HttpEntity<DeliveryInfo> httpEntity = new HttpEntity<>(deliveryInfo);


        RestTemplate restTemplate = new RestTemplate();
        deliveryInfo = restTemplate.postForObject("http://localhost:8762/delivery/deliveries",
                httpEntity, DeliveryInfo.class);

        //TODO move url into the application.properties
        order.setDeliveryInfo(deliveryInfo);

        return orderRepository.save(order);
    }

    @Override
    public Order findOne(long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }

    @Override
    public Order update(Order order) {
        if (order.getId() == null) {
            throw new OrderException("Id can not be null!");
        }

        Order existingOrder = this.findOne(order.getId());

        if (existingOrder == null) {
            throw new NoResourceException("Resource not found!");
        }

        return orderRepository.saveAndFlush(order);
    }

    @Override
    public DeliveryInfo deleteById(long id) {
        orderRepository.deleteById(id);
        //TODO update deliveryinfo and return that
        return null;
    }

    /**
     * Only for test purposes
     *
     * @return
     */
    @Override
    public DeliveryInfo createTestOrder() {

        Order order = new Order();
        order.setOrderStatus(OrderStatus.CREATED);
        order.setPaymentStatus(PaymentStatus.WAITING);

        List<OrderItem> orderItems = new ArrayList<>();

        OrderItem item1 = new OrderItem();
        item1.setOrder(order);
        item1.setProduct(productRepository.findById(1l).get());
        item1.setQuantity(2);

        OrderItem item2 = new OrderItem();
        item2.setOrder(order);
        item2.setProduct(productRepository.findById(2l).get());
        item2.setQuantity(10);

        orderItems.add(item1);
        orderItems.add(item2);
        order.setOrderItems(orderItems);

        orderRepository.save(order);

        return null; //TODO return deliveryinfo from delivery module
    }

    /**
     * Order validation in the case of a new order
     *
     * @param order
     */
    private void validateOrder(Order order) {
        if (order.getPaymentStatus() != null) {
            throw new PaymentException("PaymentStatus has to be null in new Order!");
        }

        if (order.getOrderStatus() != null) {
            throw new OrderException("OrderStatus has to be null in new Order!");
        }
    }
}
