package com.eventcount.eventsourcing.aggregates;

/**
 * Email state
 *
 * @author eventcount
 */
public enum EmailState implements ObjectState {
    CREATED,
    SENT,
    DELIVERED,
    READ,
    FAILED,
    REPLIED,
    DELETED
}
