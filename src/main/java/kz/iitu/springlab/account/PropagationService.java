
package kz.iitu.springlab.account;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PropagationService {

    private final AuditService auditService;

    public PropagationService(AuditService auditService) {
        this.auditService = auditService;
    }

    @Transactional
    public void testRequired() {
        auditService.logRequired("REQUIRED audit record");
        throw new RuntimeException("Outer transaction failed");
    }

    @Transactional
    public void testRequiresNew() {
        auditService.logRequiresNew("REQUIRES_NEW audit record");
        throw new RuntimeException("Outer transaction failed");
    }
}
