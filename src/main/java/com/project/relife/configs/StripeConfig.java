package com.project.relife.configs;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;

public class StripeConfig {



    @PostConstruct
    public void init() {
        String apiKey = System.getenv("STRIPE_API_KEY");

        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("API key is not set. Please set the OPENAI_API_KEY environment variable.");
        }

        Stripe.apiKey = apiKey;
    }
}
