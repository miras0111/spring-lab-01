package kz.iitu.springlab.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CaseController {

    @GetMapping("/case")
    public Map<String, String> caseText(
            @RequestParam String text) {

        String titleCase = java.util.Arrays.stream(text.trim().split("\\s+"))
                .map(word -> word.substring(0, 1).toUpperCase()
                        + word.substring(1).toLowerCase())
                .reduce((a, b) -> a + " " + b)
                .orElse("");

        return Map.of(
                "original", text,
                "upper", text.toUpperCase(),
                "lower", text.toLowerCase(),
                "titleCase", titleCase
        );
    }
}