package com.sos.app.model;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Created by bibin kt .
 */
@Entity
@Table(name = "contacts")
public class SosContacts {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long cid;


    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getContactNumber() {
        return contactNumber;

    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }


    @NotBlank
    private String contactNumber;
}
