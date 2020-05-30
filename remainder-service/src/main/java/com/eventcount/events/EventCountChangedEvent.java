package com.eventcount.events;

import com.eventcount.entities.EventCount;
import com.fasterxml.jackson.annotation.JsonIgnore;


public interface EventCountChangedEvent {

    @JsonIgnore
    int getPriority();

    EventCount getEventCount();

}
