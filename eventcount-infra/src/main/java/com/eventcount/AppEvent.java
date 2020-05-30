package com.eventcount;

import java.time.Instant;

/**
 *
 * The application event
 *
 * @author eventcount
 */
public interface AppEvent {

    String uuid();

    Instant when();

}
