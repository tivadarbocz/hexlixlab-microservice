package hu.helixlab.ms.delivery.service;

import hu.helixlab.ms.dao.repository.DeliveryInfoRepository;
import hu.helixlab.ms.dao.repository.EmailRepository;
import hu.helixlab.ms.entity.domain.DeliveryInfo;
import hu.helixlab.ms.entity.domain.Email;
import hu.helixlab.ms.entity.enumeration.EmailStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryInfoRepository deliveryInfoRepository;
    private final EmailRepository emailRepository;

    public DeliveryServiceImpl(DeliveryInfoRepository deliveryInfoRepository, EmailRepository emailRepository) {
        this.deliveryInfoRepository = deliveryInfoRepository;
        this.emailRepository = emailRepository;
    }

    @Override
    public DeliveryInfo createDelivery(DeliveryInfo deliveryInfo) {
        deliveryInfo.setBarCode(UUID.randomUUID().toString());
        deliveryInfoRepository.save(deliveryInfo);

        Email email = new Email();
        email.setEmailStatus(EmailStatus.CREATED);
        email.setRecipientEmail(deliveryInfo.getRecipientEmail());
        email.setSenderEmail(deliveryInfo.getSenderEmail());
        email.setSubject("Order status");
        email.setText("Bla bla bla");
        //TODO ... Maybe use a converter?

        emailRepository.save(email);

        return deliveryInfo;
    }

    @Override
    public DeliveryInfo delete(DeliveryInfo deliveryInfo) {
        return null;
    }

    @Override
    public List<DeliveryInfo> findAll() {
        return null;
    }

    @Override
    public DeliveryInfo findOne(Long id) {
        return null;
    }

    @Override
    public DeliveryInfo updateDelivery(DeliveryInfo deliveryInfo) {
        return null;
    }
}
