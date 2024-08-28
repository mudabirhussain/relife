package com.project.relife.enums;

public enum CurrencyEnum {
    USD("USD"),
    EURO("EURO");

    private String currency;

    private CurrencyEnum(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
