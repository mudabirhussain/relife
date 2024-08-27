package com.project.relife.dtos;

public record PaymentIntentRecord(
        Long amount,
        String currency,
        String status,
        String clientSecret) {
}
