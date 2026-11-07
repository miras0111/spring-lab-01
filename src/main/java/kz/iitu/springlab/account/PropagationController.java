
package kz.iitu.springlab.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/propagation")
public class PropagationController {

    private final PropagationService service;

    public PropagationController(PropagationService service) {
        this.service = service;
    }

    @GetMapping("/required")
    public String testRequired() {
        service.testRequired();
        return "REQUIRED completed";
    }

    @GetMapping("/requires-new")
    public String testRequiresNew() {
        service.testRequiresNew();
        return "REQUIRES_NEW completed";
    }
}
