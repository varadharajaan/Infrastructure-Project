package com.eventcount.pojos;

import com.eventcount.entities.EventCount;

/**
 * Socket message output.
 *
 * @author eventcount
 */
public class SocketOutputMessage {

    private final EventCount todo;
    private final String state;
    private final String time;

    public SocketOutputMessage(EventCount todo, String state, String time) {
        this.todo = todo;
        this.state = state;
        this.time = time;
    }

    public EventCount getEventCount() {
        return todo;
    }

    public String getState() {
        return state;
    }

    public String getTime() {
        return time;
    }

}
