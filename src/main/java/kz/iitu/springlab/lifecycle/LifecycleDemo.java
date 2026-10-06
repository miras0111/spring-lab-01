package kz.iitu.springlab.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class LifecycleDemo {

    public LifecycleDemo() {
        System.out.println("LIFECYCLE >> 1. Constructor called");
    }

    @PostConstruct
    public void init() {
        System.out.println("LIFECYCLE >> 2. @PostConstruct executed");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("LIFECYCLE >> 3. @PreDestroy executed");
    }
}
