package kz.iitu.springlab.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class BmiController {

    @GetMapping("/bmi")
    public Map<String, Object> bmi(
            @RequestParam double weight,
            @RequestParam double height) {

        if (weight <= 0 || height <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Weight and height must be greater than 0"
            );
        }

        double bmi = weight / (height * height);

        String category;

        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi < 25) {
            category = "Normal weight";
        } else if (bmi < 30) {
            category = "Overweight";
        } else {
            category = "Obese";
        }

        return Map.of(
                "weight", weight,
                "height", height,
                "bmi", Math.round(bmi * 100.0) / 100.0,
                "category", category
        );
    }
}