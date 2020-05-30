package com.eventcount.events;

import com.eventcount.annotations.ChangeEvent;
import com.eventcount.entities.EventCount;
import com.eventcount.AbstractDomainEvent;


@ChangeEvent(ChangeEvent.Type.UPDATE)
public class EventCountUpdatedEvent extends AbstractDomainEvent implements EventCountChangedEvent {

    private EventCount todo;

    public EventCountUpdatedEvent(EventCount todo) {
        this.todo = todo;
    }

    public EventCountUpdatedEvent() {
    }

    public EventCount getEventCount() {
        return todo;
    }

    public void setEventCount(EventCount todo) {
        this.todo = todo;
    }

    public int getPriority() {
        return this.todo.getPriority();
    }

    @Override
    public String toString() {
        return "EventCountChangeEvent{" + "todo=" + todo.getDescription() + '}';
    }

}
