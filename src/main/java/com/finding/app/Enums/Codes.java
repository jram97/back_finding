package com.finding.app.Enums;

public enum Codes{
    OK(200),
    CREATED(201),
    ACCEPTED(202),
    NO_CONTENT(204),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    NOT_ACCEPTABLE(406),
    SERVER_ERROR(500);

    private final int value;

    Codes(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
