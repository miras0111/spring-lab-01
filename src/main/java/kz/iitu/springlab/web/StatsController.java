package kz.iitu.springlab.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StatsController {

    @GetMapping("/stats")
    public Map<String, Double> stats(
            @RequestParam String numbers) {

        double[] values = Arrays.stream(numbers.split(","))
                .mapToDouble(Double::parseDouble)
                .toArray();

        double min = Arrays.stream(values).min().orElse(0);
        double max = Arrays.stream(values).max().orElse(0);
        double average = Arrays.stream(values).average().orElse(0);

        return Map.of(
                "minimum", min,
                "maximum", max,
                "average", average
        );
    }
}