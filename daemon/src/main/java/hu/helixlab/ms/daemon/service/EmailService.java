package hu.helixlab.ms.daemon.service;

import hu.helixlab.ms.entity.domain.Email;

import java.util.List;

public interface EmailService {

    void send(Email email);

    List<Email> findAllSendable();
}
