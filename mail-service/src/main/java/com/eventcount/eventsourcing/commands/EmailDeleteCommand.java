package com.eventcount.eventsourcing.commands;

/**
 * Email delete command
 *
 * @author eventcount
 */
public class EmailDeleteCommand {

    private String uuid;

    public EmailDeleteCommand(String id) {
        this.uuid = id;
    }

    public String getUuid() {
        return uuid;
    }

}
