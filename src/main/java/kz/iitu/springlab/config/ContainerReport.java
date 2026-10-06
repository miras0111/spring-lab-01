package kz.iitu.springlab.config;

import kz.iitu.springlab.notify.Notifier;
import kz.iitu.springlab.notify.NotificationService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ContainerReport {

    public ContainerReport(ApplicationContext context) {

        System.out.println(
                "CONTAINER REPORT >> bean definitions = "
                        + context.getBeanDefinitionCount()
        );

        System.out.println(
                "CONTAINER REPORT >> Notifier beans = "
                        + context.getBeansOfType(Notifier.class).size()
        );

        System.out.println(
                "CONTAINER REPORT >> NotificationService class = "
                        + context.getBean(NotificationService.class)
                        .getClass()
                        .getName()
        );
    }
}
