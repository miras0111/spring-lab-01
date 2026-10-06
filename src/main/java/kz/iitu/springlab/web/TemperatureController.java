package kz.iitu.springlab.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TemperatureController {

    @GetMapping("/temperature")
    public Map<String, Double> temperature(
            @RequestParam double fahrenheit) {

        double celsius = (fahrenheit - 32) * 5 / 9;
        double kelvin = celsius + 273.15;

        return Map.of(
                "fahrenheit", fahrenheit,
                "celsius", celsius,
                "kelvin", kelvin
        );
    }
}