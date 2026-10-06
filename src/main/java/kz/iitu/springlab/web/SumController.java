package kz.iitu.springlab.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class SumController {

    @GetMapping("/sum")
    public Map<String, Integer> sum(
            @RequestParam int a,
            @RequestParam int b) {

        return Map.of(
                "sum", a + b,
                "difference", a - b,
                "product", a * b
        );
    }
}