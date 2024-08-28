package com.project.relife.enums;

public enum PaymentMode {

    STRIPE("STRIPE"),
    PAYPAL("PAYPAL");

    private String mode;

    private PaymentMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
}
