package com.project.relife.services;

import com.project.relife.dtos.PaymentIntentRecord;
import com.project.relife.dtos.mappers.MapperDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    private MapperDTO mapperDTO;

    public StripeService(MapperDTO mapperDTO){
        this.mapperDTO = mapperDTO;
    }

    public ResponseEntity<PaymentIntentRecord> createPaymentIntent(long amount, String currency) throws StripeException {
        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(amount)
                        .setCurrency(currency)
                        .build();

        PaymentIntent paymentIntent  = PaymentIntent.create(params);
        PaymentIntentRecord record = mapperDTO.paymentIntentToRecord(paymentIntent);

        return ResponseEntity.ok(record);
    }

    public Charge createCharge(String token, long amount, String currency, String description) throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", amount);
        chargeParams.put("currency", currency);
        chargeParams.put("description", description);
        chargeParams.put("source", token);

        return Charge.create(chargeParams);
    }
}
