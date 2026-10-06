package kz.iitu.springlab.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ReverseController {

    @GetMapping("/reverse")
    public Map<String, String> reverse(
            @RequestParam String text) {

        String reversed = new StringBuilder(text)
                .reverse()
                .toString();

        return Map.of(
                "original", text,
                "reversed", reversed
        );
    }
}