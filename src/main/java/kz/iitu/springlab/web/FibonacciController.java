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
public class FibonacciController {

    @GetMapping("/fibonacci")
    public Map<String, Object> fibonacci(
            @RequestParam int n) {

        if (n < 1 || n > 50) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "n must be between 1 and 50"
            );
        }

        List<Long> numbers = new ArrayList<>();

        long a = 0;
        long b = 1;

        for (int i = 0; i < n; i++) {
            numbers.add(a);

            long next = a + b;
            a = b;
            b = next;
        }

        return Map.of(
                "n", n,
                "fibonacci", numbers
        );
    }
}
