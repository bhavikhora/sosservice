package com.sos.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by bibin kt .
 */
@Entity
@Table(name = "settings")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class SosProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    public Boolean getEnableSocial() {
        return enableSocial;
    }

    public void setEnableSocial(Boolean enableSocial) {
        this.enableSocial = enableSocial;
    }

    public String getMobile1() {

        return mobile1;
    }

    public Boolean getPaidService() {
        return paidService;
    }

    public void setPaidService(Boolean paidService) {
        this.paidService = paidService;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    @NotBlank
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank

    private String mobile1;

    private Boolean paidService;

    private Boolean enableSocial;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
