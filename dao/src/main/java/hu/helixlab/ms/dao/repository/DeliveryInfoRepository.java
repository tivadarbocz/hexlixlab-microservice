package hu.helixlab.ms.dao.repository;

import hu.helixlab.ms.entity.domain.DeliveryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryInfoRepository extends JpaRepository<DeliveryInfo, Long> {
}
