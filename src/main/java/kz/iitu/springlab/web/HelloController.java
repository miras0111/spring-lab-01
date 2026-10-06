package kz.iitu.springlab.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Value("${app.owner:unknown}")
    private String owner;

    @GetMapping("/hello")
    public Map<String, String> hello(
            @RequestParam(defaultValue = "world") String name) {

        return Map.of(
                "message", "Hello, " + name + "!",
                "owner", owner
        );
    }

    @GetMapping("/info")
    public Map<String, String> info() {
        return Map.of(
                "application", "spring-lab-01",
                "owner", owner
        );
    }
}