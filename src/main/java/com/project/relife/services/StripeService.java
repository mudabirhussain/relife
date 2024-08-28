package com.project.relife.services;

import com.project.relife.dtos.PaymentIntentRecord;
import com.project.relife.dtos.mappers.MapperDTO;
import com.project.relife.dtos.requests.CartRequest;
import com.project.relife.dtos.requests.ProductRequest;
import com.project.relife.enums.CurrencyEnum;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.PaymentIntent;
import com.stripe.model.checkout.Session;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class StripeService {

    private final MapperDTO mapperDTO;
    private final ProductService productService;

    @Value("${client.base.url}")
    private String clientBaseUrl;

    private final CheckoutSessionService checkoutSessionService;

    public StripeService(CheckoutSessionService checkoutSessionService, MapperDTO mapperDTO, ProductService productService){
        this.mapperDTO = mapperDTO;
        this.checkoutSessionService = checkoutSessionService;
        this.productService = productService;
    }

    public ResponseEntity<PaymentIntentRecord> createPaymentIntent(CartRequest cartRequest) throws StripeException {
        Long calculatedPrice = calculateCart(cartRequest);
        System.out.println("Calculated Price: "+calculatedPrice);
        System.out.println("Client's Price: "+ cartRequest.getTotal());
        if(!calculatedPrice.equals(cartRequest.getTotal())){
            throw new RuntimeException("Price Mismatch, Please Review");
        }
        if(!cartRequest.getCurrencyEnum().equals(CurrencyEnum.USD)){
            throw new RuntimeException("Only USD Currency Supported");
        }
        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(calculatedPrice)
                        .setCurrency(cartRequest.getCurrencyEnum().getCurrency())
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

    public String processHostedCheckoutUrl(CartRequest cartRequest) throws StripeException {
        // Processing with the session params
        SessionCreateParams sessionParams = checkoutSessionService.createSessionParams(cartRequest, clientBaseUrl);
        Session session = Session.create(sessionParams);

        // Return the session URL
        return session.getUrl();
    }

    private Long calculateCart(CartRequest cartRequest) throws RuntimeException{
        long calculatedPrice = 0L;

        for (ProductRequest productReq : cartRequest.getProductRequest()) {
            Optional<Long> optionalPrice = productService.getProductPriceByProductId(productReq.getProductId());
            if(optionalPrice.isEmpty()){
                throw new RuntimeException("Price for product with ID " + productReq.getProductId() + " is null.");
            }
            calculatedPrice += optionalPrice.get();
        }
        return calculatedPrice;
    }
}
