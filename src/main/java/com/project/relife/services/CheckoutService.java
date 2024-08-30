package com.project.relife.services;

import com.project.relife.dtos.requests.CartRequest;
import com.project.relife.services.internals.CheckoutSessionService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    @Value("${client.base.url}")
    private String clientBaseUrl;

    private final CheckoutSessionService checkoutSessionService;

    public CheckoutService(CheckoutSessionService checkoutSessionService) {
        this.checkoutSessionService = checkoutSessionService;
    }

    public String processCheckout(CartRequest cartRequest) throws StripeException {
        // Processing with the session params
        SessionCreateParams sessionParams = checkoutSessionService.createSessionParams(cartRequest, clientBaseUrl);

        // Creating the stripe session with params
        Session session = Session.create(sessionParams);

        // Return the session URL
        return session.getUrl();
    }
}
