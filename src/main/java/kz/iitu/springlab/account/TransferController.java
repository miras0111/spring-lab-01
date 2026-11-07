
package kz.iitu.springlab.account;

import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    private final TransferService service;

    public TransferController(TransferService service) {
        this.service = service;
    }

    @GetMapping("/send")
    public String transfer(
            @RequestParam Long from,
            @RequestParam Long to,
            @RequestParam BigDecimal amount) {

        service.transfer(from, to, amount);
        return "Transfer successful: " + amount;
    }

    @GetMapping("/rollback")
    public String rollback() {
        service.transferWithError(1L, 2L, new BigDecimal("100"));
        return "Done";
    }
}
