package hu.helixlab.ms.delivery.controller;

import hu.helixlab.ms.entity.domain.DeliveryInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class DeliveryRestController {

    @ApiOperation(value = "Create a transport based on a deliveryinfo", notes = "Create transport")
    @PostMapping(value = "deliveries", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DeliveryInfo createDelivery(@RequestBody DeliveryInfo deliveryInfo) {

//        deliveryInfo.setStatus("delivered");

        return deliveryInfo;
    }
}
