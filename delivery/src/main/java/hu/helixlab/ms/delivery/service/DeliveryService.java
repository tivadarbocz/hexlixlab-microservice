package hu.helixlab.ms.delivery.service;

import hu.helixlab.ms.entity.domain.DeliveryInfo;

import java.util.List;

public interface DeliveryService {

    DeliveryInfo createDelivery(DeliveryInfo deliveryInfo);

    DeliveryInfo delete(DeliveryInfo deliveryInfo);

    List<DeliveryInfo> findAll();

    DeliveryInfo findOne(Long id);

    DeliveryInfo updateDelivery(DeliveryInfo deliveryInfo);

}
