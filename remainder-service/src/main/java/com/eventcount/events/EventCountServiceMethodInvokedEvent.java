package com.eventcount.events;


public class EventCountServiceMethodInvokedEvent {

    private String methodName;
    private long duration;

    public EventCountServiceMethodInvokedEvent(String methodName, long duration) {
        this.methodName = methodName;
        this.duration = duration;
    }

    public EventCountServiceMethodInvokedEvent() {
    }

    public String getMethodName() {
        return methodName;
    }

    public long getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "CallEvent{" + "methodName=" + methodName + ", duration=" + duration + '}';
    }

}
