package kz.iitu.springlab.notify;

import jakarta.annotation.PostConstruct;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("upper")
@Order(3)
public class UpperNotifier implements Notifier {

    @PostConstruct
    public void init() {
        System.out.println("CUSTOM >> upper notifier initialized");
    }

    @Override
    public String send(String message) {
        return message.toUpperCase();
    }

    @Override
    public String channel() {
        return "upper";
    }
}