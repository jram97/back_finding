package com.finding.app.Enums;

public enum Messages{
    SUCCESS("Request was successful"),
    ERROR("Opps! Request was not successful"),
    EMPTY("Entity is empty"),
    SAVE("Entity was saved successfully"),
    NOT_FOUND("Not found or does not exist"),
    DELETE("Entity was successfully removed"),
    DELETE_ALL("This entity was successfully removed");
	
    private final String value;

    Messages(final String newValue) {
        value = newValue;
    }

    public String getValue() { return value; }
}
