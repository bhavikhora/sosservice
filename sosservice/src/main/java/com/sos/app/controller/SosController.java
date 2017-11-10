package com.sos.app.controller;

import com.sos.app.model.NotifyDetail;
import com.sos.app.model.SosProfile;
import com.sos.app.repository.SosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by bibiKT .
 */
@RestController
@RequestMapping("/api")
public class SosController {

    @Autowired
    SosRepository sosRepository;

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
        return sosRepository.save(sosProfile);
    }

    @PostMapping("/notify")
    public String pushMessage(@Valid @RequestBody NotifyDetail sosProfile) {
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
