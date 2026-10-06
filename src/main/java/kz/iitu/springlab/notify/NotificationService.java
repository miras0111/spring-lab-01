package kz.iitu.springlab.notify;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NotificationService {

    private final Notifier notifier;
    private final List<Notifier> notifiers;
    private final Map<String, Notifier> notifierMap;

    public NotificationService(
            Notifier notifier,
            List<Notifier> notifiers,
            Map<String, Notifier> notifierMap) {

        this.notifier = notifier;
        this.notifiers = notifiers;
        this.notifierMap = notifierMap;
    }

    public String notify(String message) {
        return notifier.send(message);
    }

    public List<String> channels() {
        return notifiers.stream()
                .map(Notifier::channel)
                .toList();
    }

    public Map<String, Notifier> notifierMap() {
        return notifierMap;
    }
}