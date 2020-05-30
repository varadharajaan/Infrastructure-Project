package com.eventcount.mailservice.integration.reminder;

import com.eventcount.AbstractDomainEvent;

/**
 * To Do created event
 *
 * @author eventcount
 */
public class EventCountCreatedEvent extends AbstractDomainEvent {

    private ToDoDto todo;

    public EventCountCreatedEvent(ToDoDto todo) {
        this.todo = todo;
    }

    public EventCountCreatedEvent() {
    }

    public ToDoDto getEventCount() {
        return todo;
    }

    public void setEventCount(ToDoDto todo) {
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
