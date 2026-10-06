package kz.iitu.springlab.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PrimeController {

    @GetMapping("/prime")
    public Map<String, Object> prime(
            @RequestParam int n) {

        if (n < 1) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "n must be greater than 0"
            );
        }

        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }

        boolean isPrime = divisors.size() == 2;

        return Map.of(
                "number", n,
                "isPrime", isPrime,
                "divisors", divisors
        );
    }
}