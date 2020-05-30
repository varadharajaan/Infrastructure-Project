package com.eventcount.eventsourcing.aggregates;

import com.eventcount.AppEvent;
import java.util.List;

/**
 * The aggregate interface
 *
 * @author eventcount
 */
public interface Aggregate {

    String getUuid();

    List<AppEvent> getUncommittedChanges();

    Aggregate markChangesAsCommitted();


}
