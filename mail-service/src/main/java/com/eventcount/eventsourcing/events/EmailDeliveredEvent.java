package com.eventcount.eventsourcing.events;

import com.eventcount.eventsourcing.entities.Email;
import com.eventcount.AbstractDomainEvent;
import java.time.Instant;

/**
 * Email delivered event
 *
 * @author eventcount
 */
public class EmailDeliveredEvent extends AbstractDomainEvent implements EmailEvent {

    private final String uuid;
    private final Instant when = Instant.now();
    private final String type = "sent";
    
    private final Email email;

    public EmailDeliveredEvent(String uuid, Email email) {
        this.uuid = uuid;
        this.email = email;
    }

    @Override
    public String uuid() {
        return uuid;
    }

    public String type() {
        return type;
    }

    @Override
    public Instant when() {
        return when;
    }

    @Override
    public Email getEmail() {
        return email;
    }

}
