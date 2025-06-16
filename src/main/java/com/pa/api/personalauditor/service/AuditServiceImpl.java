package com.pa.api.personalauditor.service;

import com.pa.api.personalauditor.entity.AuditEntity;
import com.pa.api.personalauditor.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class AuditServiceImpl implements AuditService{


    @Autowired
    AuditRepository auditRepository;

    @Override
    public String auditEntry(@RequestParam AuditEntity auditEntity) {

        AuditEntity save = auditRepository.save(auditEntity);
        return "Audit Entry created successfully"+" with ID: " + save.getAuditId();
    }

    @Override
    public List<AuditEntity> findAll() {
        return List.of();
    }
}
