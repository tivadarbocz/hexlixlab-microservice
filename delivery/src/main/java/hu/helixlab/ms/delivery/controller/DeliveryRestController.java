package hu.helixlab.ms.delivery.controller;

import domain.DeliveryInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeliveryRestController {

    //TODO implementation
    //TODO swagger
    @PostMapping(value = "deliveries", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DeliveryInfo createDelivery(@RequestBody DeliveryInfo deliveryInfo) {

        deliveryInfo.setStatus("delivered");

        return deliveryInfo;
    }
}
