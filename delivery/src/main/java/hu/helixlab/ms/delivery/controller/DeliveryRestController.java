package hu.helixlab.ms.delivery.controller;

import hu.helixlab.ms.delivery.service.DeliveryService;
import hu.helixlab.ms.entity.domain.DeliveryInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
public class DeliveryRestController {

    private final DeliveryService deliveryService;

    public DeliveryRestController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @ApiOperation(value = "Create a transport based on a deliveryinfo", notes = "Create transport")
    @PostMapping(value = "deliveries", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DeliveryInfo createDelivery(@RequestBody DeliveryInfo deliveryInfo) {
        return deliveryService.createDelivery(deliveryInfo);
    }

    @ApiOperation(value = "Delete a transport based on a deliveryinfo", notes = "Delete transport")
    @DeleteMapping(value = "deliveries", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DeliveryInfo delete(@RequestBody DeliveryInfo deliveryInfo) {
        return deliveryInfo;
    }

    @ApiOperation(value = "Find all transport", notes = "Find all transport")
    @GetMapping(value = "deliveries", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<DeliveryInfo> findAll() {
        return null;
    }

    @ApiOperation(value = "Find one transport by id", notes = "Find one transport")
    @GetMapping(value = "deliveries/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DeliveryInfo findOne(@PathVariable("id") Long id) {
        return null;
    }

    @ApiOperation(value = "Update a transport based on a deliveryinfo", notes = "Update transport")
    @PutMapping(value = "deliveries", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DeliveryInfo updateDelivery(@RequestBody DeliveryInfo deliveryInfo) {

//        deliveryInfo.setStatus("delivered");

        return deliveryInfo;
    }

}
