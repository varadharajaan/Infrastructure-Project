package com.eventcount.controllers;

import com.eventcount.monitors.EventCountServiceMethodInvokedStore;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LongSummaryStatistics;

@RequestMapping("/todo-statistics")
@RestController
public class EventCountServiceStatisticsController {

    @Autowired
    EventCountServiceMethodInvokedStore monitor;

    @GetMapping
    public ObjectNode get() {
        LongSummaryStatistics statistics = monitor.getStatistics();
        return JsonNodeFactory.instance.objectNode().
                put("average-duration", statistics.getAverage()).
                put("invocation-count", statistics.getCount()).
                put("min-duration", statistics.getMin()).
                put("max-duration", statistics.getMax());
    }

}
