package com.eventcount.monitors;

import com.eventcount.events.EventCountChangedEvent;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * Store ToDo event changes.
 *
 * @author eventcount
 */
@Component
public class EventCountStoreEventChanges {

    private CopyOnWriteArrayList<EventCountChangedEvent> events;

    @PostConstruct
    public void init() {
        this.events = new CopyOnWriteArrayList<>();
    }

    public void addNewEvent(EventCountChangedEvent event) {
        this.events.add(event);
    }

    public List<EventCountChangedEvent> getRecentEvents() {
        return this.events;
    }

    public LongSummaryStatistics getStatistics() {
        return this.events.stream().
                collect(Collectors.summarizingLong(EventCountChangedEvent::getPriority));
    }
}
