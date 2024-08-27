package com.project.relife.enums;

public enum ResponseStatus {
    CUSTOMER_NOT_FOUND("CUST-001", "Customer not found"),
    PAYMENT_FAILED("PAY-001", "Payment processing failed"),
    PRODUCT_NOT_AVAILABLE("PROD-001", "Product not available");

    private String code;
    private String message;

    private ResponseStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
