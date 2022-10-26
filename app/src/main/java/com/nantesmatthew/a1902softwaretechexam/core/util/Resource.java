package com.nantesmatthew.a1902softwaretechexam.core.util;

public class Resource<T> {
    private T payload;
    private Status status;
    private String message;

    public Resource(T payload, Status status, String message) {
        this.payload = payload;
        this.status = status;
        this.message = message;
    }

    public T getPayload() {
        return payload;
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}

