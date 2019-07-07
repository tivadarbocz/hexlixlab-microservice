package hu.helixlab.ms.daemon.service;

import hu.helixlab.ms.entity.domain.Email;

import java.util.List;

public interface EmailService {

    /**
     * TODO
     *
     * @param email
     */
    void send(Email email);

    /**
     * TODO
     * @return
     */
    List<Email> findAllSendable();

    /**
     * TODO
     *
     * @param email
     * @return
     */
    Email save(Email email);
}
