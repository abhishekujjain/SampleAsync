package com.ujjain.asyncapi.sampleasync.model;

/**
 * Created by abhishekujjain on 10/05/20.
 */
public class WorkFlow {
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        NEW,OLD
    }
}
