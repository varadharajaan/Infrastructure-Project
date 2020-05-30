package com.eventcount.monitors;

import com.eventcount.EventPublisher;
import com.eventcount.entities.EventCount;
import com.eventcount.events.EventCountCreatedEvent;
import com.eventcount.events.EventCountUpdatedEvent;
import com.eventcount.helpers.AutowireHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

/**
 * ToDo's entity listener
 *
 * @author eventcount
 */
public class EventCountEntityListener {

    @Autowired
    private EventPublisher publisher;

    @PostPersist
    public void onPersist(EventCount todo) {

        AutowireHelper.autowire(this, this.publisher);
        this.publisher.publish(new EventCountCreatedEvent(todo));
    }

    @PostUpdate
    public void onUpdate(EventCount todo) {
        AutowireHelper.autowire(this, this.publisher);
        this.publisher.publish(new EventCountUpdatedEvent(todo));
    }

}
