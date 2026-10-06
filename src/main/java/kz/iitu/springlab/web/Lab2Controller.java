package kz.iitu.springlab.web;

import kz.iitu.springlab.notify.NotificationService;
import kz.iitu.springlab.scope.TicketOffice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/lab2")
public class Lab2Controller {

    private final NotificationService notificationService;
    private final TicketOffice ticketOffice;

    public Lab2Controller(NotificationService notificationService,
                          TicketOffice ticketOffice) {
        this.notificationService = notificationService;
        this.ticketOffice = ticketOffice;
    }

    @GetMapping("/notify")
    public String notify(@RequestParam String text) {
        return notificationService.notify(text);
    }

    @GetMapping("/scopes")
    public Map<String, String> scopes() {
        return Map.of(
                "direct1", ticketOffice.getDirectTicketId(),
                "direct2", ticketOffice.getDirectTicketId(),
                "fresh1", ticketOffice.getFreshTicketId(),
                "fresh2", ticketOffice.getFreshTicketId()
        );
    }

    @GetMapping("/channels")
    public Object channels() {
        return notificationService.channels();
    }
}
