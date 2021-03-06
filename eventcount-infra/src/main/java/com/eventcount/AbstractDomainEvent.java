package com.eventcount;

import java.time.Instant;

/**
 * Abstract system event. The domain event across all services
 *
 * @author eventcount
 */
public abstract class AbstractDomainEvent implements AppEvent {

    protected  String uuid;
    
    protected Instant when = Instant.now();

    @Override
    public String uuid() {
        return uuid;
    }

    @Override
    public Instant when() {
        return when;
    }
}
