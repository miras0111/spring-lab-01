
package kz.iitu.springlab.account;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

@Service
public class TransferService {

    private final AccountRepository repository;

    public TransferService(AccountRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void transfer(Long fromId, Long toId, BigDecimal amount) {
        if (fromId.equals(toId)) {
            throw new IllegalArgumentException("Accounts must be different");
        }

        Account from = repository.findById(fromId).orElseThrow();
        Account to = repository.findById(toId).orElseThrow();

        from.debit(amount);
        to.credit(amount);

        repository.save(from);
        repository.save(to);
    }

    @Transactional
    public void transferWithError(Long fromId, Long toId, BigDecimal amount) {
        Account from = repository.findById(fromId).orElseThrow();
        from.debit(amount);
        repository.saveAndFlush(from);

        throw new RuntimeException("Test rollback");
    }
}
