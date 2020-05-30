package com.eventcount.mailservice.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Event sourcing module configuration
 *
 * @author eventcount
 */
@ComponentScan({"com.eventcount.eventsourcing"})
@Configuration
public class EventSourcingConfig {

}
