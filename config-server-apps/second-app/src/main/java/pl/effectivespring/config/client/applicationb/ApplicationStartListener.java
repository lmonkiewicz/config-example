package pl.effectivespring.config.client.applicationb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartListener implements SmartApplicationListener {

    private final static Logger LOG = LoggerFactory.getLogger(ApplicationStartListener.class);

    @Value("${app.welcome.msg:NONE}")
    private String welcomeMessage;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationStartedEvent) {
            LOG.info("Application started. {}", welcomeMessage);
        }
    }

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == ApplicationStartedEvent.class;
    }
}
