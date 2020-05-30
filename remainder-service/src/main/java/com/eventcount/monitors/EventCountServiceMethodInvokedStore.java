package com.eventcount.monitors;

import com.eventcount.events.EventCountServiceMethodInvokedEvent;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * Store EventCountService method invoked.
 *
 * @author eventcount
 */
@Component
public class EventCountServiceMethodInvokedStore {

    private CopyOnWriteArrayList<EventCountServiceMethodInvokedEvent> events;

    @PostConstruct
    public void init() {
        this.events = new CopyOnWriteArrayList<>();
    }

    public void addNewEvent(EventCountServiceMethodInvokedEvent event) {
        this.events.add(event);
    }

    public List<EventCountServiceMethodInvokedEvent> getRecentChanges() {
        return this.events;
    }

    public LongSummaryStatistics getStatistics() {
        return this.events.stream().
                collect(Collectors.summarizingLong(EventCountServiceMethodInvokedEvent::getDuration));
    }
}
