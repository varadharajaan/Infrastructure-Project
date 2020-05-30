package com.eventcount.eventsourcing.events;

import com.eventcount.eventsourcing.entities.Email;
import com.eventcount.AbstractDomainEvent;

/**
 * Email sent event
 *
 * @author eventcount
 */
public class EmailSentEvent extends AbstractDomainEvent implements EmailEvent {

    private final String type = "sent";
    
    private Email email;

    public EmailSentEvent(String uuid, Email email) {
        this.uuid = uuid;
        this.email = email;
    }

    @Override
    public Email getEmail() {
        return email;
    }

}
