package com.pa.api.personalauditor.service;

import com.pa.api.personalauditor.entity.Audit;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AuditService {

    public String auditEntry(@RequestParam Audit audit);

    List<Audit> findAll();
}
