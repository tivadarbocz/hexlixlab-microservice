package hu.helixlab.ms.dao.repository;

import hu.helixlab.ms.entity.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    @Query("SELECT e FROM Email e WHERE e.emailStatus NOT LIKE ':status'")
    List<Email> findAllEmailByNotLikeStatus(@Param("status") String status);
}
