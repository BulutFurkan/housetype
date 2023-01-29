package com.furkanbulut.definex_week2.model;

public enum EstateType {

    HOUSE("HOUSE"),
    VILLA("VILLA"),
    SUMMERHOUSE("SUMMERHOUSE");

    private final String value;

    public String getValue() {
        return value;
    }

    EstateType(String value) {
        this.value = value;
    }
}
