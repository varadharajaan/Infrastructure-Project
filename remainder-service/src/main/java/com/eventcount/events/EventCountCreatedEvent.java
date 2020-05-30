package com.eventcount.events;

import com.eventcount.annotations.ChangeEvent;
import com.eventcount.entities.EventCount;
import com.eventcount.AbstractDomainEvent;


@ChangeEvent(ChangeEvent.Type.CREATION)
public class EventCountCreatedEvent extends AbstractDomainEvent implements EventCountChangedEvent {

    private EventCount todo;

    public EventCountCreatedEvent(EventCount todo) {
        this.todo = todo;
    }

    public EventCountCreatedEvent() {
    }

    public EventCount getEventCount() {
        return todo;
    }

    public void setEventCount(EventCount todo) {
        this.todo = todo;
    }

    @Override
    public int getPriority() {
        return this.todo.getPriority();
    }

    @Override
    public String toString() {
        return "EventCountChangeEvent{" + "todo=" + todo.getDescription() + '}';
    }

}
