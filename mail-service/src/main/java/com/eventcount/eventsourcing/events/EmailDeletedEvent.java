package com.eventcount.eventsourcing.events;

import com.eventcount.eventsourcing.entities.Email;
import com.eventcount.AbstractDomainEvent;
import com.eventcount.AppEvent;
import java.time.Instant;

/**
 * Email deleted event
 *
 * @author eventcount
 */
public class EmailDeletedEvent extends AbstractDomainEvent implements EmailEvent {

    private final String uuid;
    private final String type = "Deleted";
    private final Instant when = Instant.now();
    
    private Email email;

    /**
     *
     * @param uuid
     * @param email
     */
    public EmailDeletedEvent(String uuid, Email email) {
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

    public Email getEmail() {
        return email;
    }

}
