package com.project.relife.controllers;

import com.project.relife.dtos.PaymentIntentRecord;
import com.project.relife.services.StripeService;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.exception.StripeException;
import com.stripe.model.Event;
import com.stripe.model.PaymentIntent;
import com.stripe.net.Webhook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class StripeController {

    private StripeService stripeService;
    private String endpointSecret = "";

    public StripeController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/intent")
    public ResponseEntity<PaymentIntentRecord> createPaymentIntent(@RequestParam long amount, @RequestParam String currency) throws StripeException {
        System.out.println("Creating payment intent with amount " + amount + " and currency " + currency);
        return stripeService.createPaymentIntent(amount, currency);
    }

    @PostMapping("/charge")
    public String createCharge(@RequestParam String token, @RequestParam long amount, @RequestParam String currency, @RequestParam String description) throws StripeException {
        return stripeService.createCharge(token, amount, currency, description).toJson();
    }

    @PostMapping("/webhook")
    public ResponseEntity<String> handleStripeWebhook(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader) {
        Event event;

        try {
            event = Webhook.constructEvent(payload, sigHeader, endpointSecret);
        } catch (SignatureVerificationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid signature");
        }

        // Handle the event
        switch (event.getType()) {
            case "payment_intent.succeeded":
                // Handle successful payment intent
                PaymentIntent paymentIntent = (PaymentIntent) event.getDataObjectDeserializer().getObject().orElse(null);
                System.out.println("Payment for " + paymentIntent.getAmount() + " succeeded.");
                // Implement further processing, like updating your database
                break;
            case "payment_intent.payment_failed":
                // Handle failed payment
                System.out.println("Payment failed.");
                break;
            case "charge.succeeded":
                // Handle failed payment
                System.out.println("Payment failed.");
                break;
            case "charge.failed":
                // Handle failed payment
                System.out.println("Payment failed.");
                break;
            // Add more event types as needed
            default:
                System.out.println("Unhandled event type: " + event.getType());
        }

        return ResponseEntity.ok("Webhook handled");
    }
}
