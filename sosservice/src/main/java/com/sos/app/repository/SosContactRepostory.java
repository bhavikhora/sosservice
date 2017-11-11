package com.sos.app.repository;

import com.sos.app.model.SosContacts;
import com.sos.app.model.SosProfile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bthiru on 11/10/2017.
 */
public interface SosContactRepostory extends JpaRepository<SosContacts, Long> {

}
