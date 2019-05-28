package repository;

import domain.DeliveryInfo;

import java.util.ArrayList;
import java.util.List;

public class DeliveryInfoRepository {

    private static final List<DeliveryInfo> deliveryInfoStore = new ArrayList<>();

    static {
        DeliveryInfoRepository.deliveryInfoStore.add(new DeliveryInfo(1L, "John", "Doe1"));
        DeliveryInfoRepository.deliveryInfoStore.add(new DeliveryInfo(2L, "John", "Doe1"));
        DeliveryInfoRepository.deliveryInfoStore.add(new DeliveryInfo(3L, "John", "Doe1"));
    }


    public List<DeliveryInfo> findAll() {
        return deliveryInfoStore;
    }

    public DeliveryInfo add(DeliveryInfo deliveryInfo) {
        deliveryInfo.setId(Long.valueOf(deliveryInfoStore.size() + 1));
        deliveryInfoStore.add(deliveryInfo);

        return deliveryInfo;
    }
}
