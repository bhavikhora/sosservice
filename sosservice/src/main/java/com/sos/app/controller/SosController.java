package com.sos.app.controller;

import com.sos.app.model.NotifyDetail;
import com.sos.app.model.SosContacts;
import com.sos.app.model.SosProfile;
import com.sos.app.repository.SosContactRepostory;
import com.sos.app.repository.SosRepository;
import com.textmagic.sdk.RestClient;
import com.textmagic.sdk.RestException;
import com.textmagic.sdk.resource.instance.TMNewMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by bibiKT .
 */
@RestController
@RequestMapping("/api")
public class SosController {

    @Autowired
    SosRepository sosRepository;
    @Autowired
    SosContactRepostory sosContactRepostory;
    @GetMapping("/settings")
    public List<SosProfile> getAllSettings() {
        return sosRepository.findAll();
    }

    @GetMapping("/settings/{id}")
    public ResponseEntity<SosProfile> getSettingById(@PathVariable(value = "id") Long noteId) {
        SosProfile sosProfile = sosRepository.findOne(noteId);
        if(sosProfile == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(sosProfile);
    }

    @PostMapping("/settings")
    public SosProfile createSetting(@Valid @RequestBody SosProfile sosProfile) {
        /*LinkedHashMap c = (LinkedHashMap)sosProfile.getContactNumbers().get(0);
        SosContacts s = new SosContacts();
        s.setCid(new Long(1));
        s.setContactNumber((String) c.get("contactNumber"));
        sosContactRepostory.save(s);*/
        return sosRepository.save(sosProfile);
    }

    @PostMapping("/notify")
    public String pushMessage(@Valid @RequestBody NotifyDetail sosProfile2) {
        RestClient client = new RestClient("bibinkt", "wI8UXXWH5MYsurdCCBWWWwnqjSRkd1");

        TMNewMessage m = client.getResource(TMNewMessage.class);
        m.setText("Hello from TextMagic Java");
        SosProfile sosProfile1 = sosRepository.findOne(sosProfile2.getId());
        m.setPhones(Arrays.asList(new String[] {sosProfile1.getMobile1(),sosProfile1.getMobile2()}));
        try {
            m.send();
        } catch (final RestException e) {
            System.out.println(e.getErrors());
            throw new RuntimeException(e);
        }
        return "OK";
    }

    @DeleteMapping("/settings/{id}")
    public ResponseEntity<SosProfile> deleteSetting(@PathVariable(value = "id") Long noteId) {
        SosProfile sosProfile = sosRepository.findOne(noteId);
        if(sosProfile == null) {
            return ResponseEntity.notFound().build();
        }

        sosRepository.delete(sosProfile);
        return ResponseEntity.ok().build();
    }
}
