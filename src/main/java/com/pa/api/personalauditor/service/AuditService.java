package com.pa.api.personalauditor.service;

import com.pa.api.personalauditor.entity.AuditEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AuditService {

    public String auditEntry(@RequestParam AuditEntity auditEntity);

    List<AuditEntity> findAll();
}
