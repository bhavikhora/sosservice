package com.sos.app.repository;

import com.sos.app.model.SosProfile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bibin kt.
 */
public interface SosRepository extends JpaRepository<SosProfile, Long> {

}
