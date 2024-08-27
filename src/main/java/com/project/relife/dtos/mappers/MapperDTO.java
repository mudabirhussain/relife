package com.project.relife.dtos.mappers;

import com.project.relife.dtos.PaymentIntentRecord;
import com.stripe.model.PaymentIntent;
import org.springframework.stereotype.Component;

@Component
public class MapperDTO {
    public PaymentIntentRecord paymentIntentToRecord(PaymentIntent paymentIntent) {
        return new PaymentIntentRecord(
                paymentIntent.getAmount(),
                paymentIntent.getCurrency(),
                paymentIntent.getStatus(),
                paymentIntent.getClientSecret()
        );
    }
}
