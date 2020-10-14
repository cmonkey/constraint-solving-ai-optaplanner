package org.excavator.boot.optaplanner.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Room {

    private String name;

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
