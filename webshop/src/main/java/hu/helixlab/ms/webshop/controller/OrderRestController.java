package hu.helixlab.ms.webshop.controller;

import hu.helixlab.ms.entity.domain.DeliveryInfo;
import hu.helixlab.ms.entity.domain.Order;
import hu.helixlab.ms.webshop.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
public class OrderRestController {

    private final OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ApiOperation(value = "Create an order", notes = "Create order")
    @PostMapping(value = "orders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @ApiOperation(value = "Find all order", notes = "Find all order")
    @GetMapping(value = "orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @ApiOperation(value = "Find one order by id", notes = "Find one order by id")
    @GetMapping(value = "orders/{id}")
    public Order findOne(@PathVariable("id") Long id) {
        return orderService.findOne(id);
    }

    @ApiOperation(value = "Delete an order by id", notes = "Delete an order by id")
    @DeleteMapping(value = "orders/{id}")
    public void delete(@PathVariable Long id) {
        orderService.deleteById(id);
    }

    @ApiOperation(value = "Update an order", notes = "Update an order without explicit id param")
    @PutMapping(value = "orders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void upldate(@RequestBody Order order) {
        orderService.update(order);
    }


    @Deprecated
    @ApiOperation(value = "Create a test order", notes = "Create test order")
    @PostMapping(value = "orders/test", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DeliveryInfo createTestOrder() {
        return orderService.createTestOrder();
    }


}
