package com.pa.api.personalauditor.service;

import com.pa.api.personalauditor.entity.AuditEntity;
import com.pa.api.personalauditor.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class AuditServiceImpl implements AuditService{


    @Autowired
    AuditRepository auditRepository;

    @Override
    public String auditEntry(@RequestParam AuditEntity auditEntity) {

        AuditEntity save = auditRepository.save(auditEntity);
        if (save == null) {
            return "Audit Entry creation failed";
        }
        // Assuming you want to return the ID of the created audit entry
        // return "Audit Entry created with ID: " + save.getId();
        return "Audit Entry created successfully"+" with ID: " + save.getId();
    }
}
