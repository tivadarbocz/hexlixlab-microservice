package hu.helixlab.ms.webshop.controller;

import domain.DeliveryInfo;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderRestController {

    @PostMapping(value = "orders")
    public DeliveryInfo createOrder() {

        DeliveryInfo deliveryInfo = new DeliveryInfo("Arany", "János");

        HttpEntity<DeliveryInfo> httpEntity = new HttpEntity<>(deliveryInfo);
        RestTemplate restTemplate = new RestTemplate();

        //TODO move url to application.properties
        return restTemplate.postForObject("http://localhost:8762/delivery/deliveries",
                httpEntity, DeliveryInfo.class);
    }
}
