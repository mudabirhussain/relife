package com.project.relife.dtos.responses;

import com.stripe.model.PaymentIntent;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;

@Getter
@Builder
public class PaymentIntentResponse {
    private Long amount;
    private String currency;
    private String status;
    private String clientSecret;

    public static PaymentIntentResponse from(@NonNull PaymentIntent paymentIntent) {
        Objects.requireNonNull(paymentIntent, "Payment intent cannot be null");
        return PaymentIntentResponse.builder()
                .amount(paymentIntent.getAmount())
                .currency(paymentIntent.getCurrency())
                .status(paymentIntent.getStatus())
                .clientSecret(paymentIntent.getClientSecret())
                .build();
    }
}
