package kz.iitu.springlab.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class WordcountController {

    @GetMapping("/wordcount")
    public Map<String, Object> wordcount(
            @RequestParam String text) {

        String trimmed = text.trim();

        String[] words = trimmed.isEmpty()
                ? new String[0]
                : trimmed.split("\\s+");

        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return Map.of(
                "wordCount", words.length,
                "characterCount", text.length(),
                "longestWord", longestWord
        );
    }
}
