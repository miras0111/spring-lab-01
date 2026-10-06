package kz.iitu.springlab.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class FactorialController {

    @GetMapping("/factorial")
    public Map<String, Object> factorial(
            @RequestParam int n) {

        long result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return Map.of(
                "number", n,
                "factorial", result
        );
    }
}