package kz.iitu.springlab.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PalindromeController {

    @GetMapping("/palindrome")
    public Map<String, Object> palindrome(
            @RequestParam String text) {

        String reversed = new StringBuilder(text)
                .reverse()
                .toString();

        boolean palindrome = text.equalsIgnoreCase(reversed);

        return Map.of(
                "text", text,
                "palindrome", palindrome
        );
    }
}
