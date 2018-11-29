package com.calculator.tdd.enums;

public enum ClientEnum {
    DEFINED_SYMBOL("//"),
    DEFAULT_DELIMITER(",");

    private String code;
    private ClientEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
