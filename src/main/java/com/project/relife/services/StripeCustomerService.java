package com.project.relife.services;

import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import com.stripe.param.CustomerCreateParams;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeCustomerService {

    public Customer findOrCreateCustomer(String email, String name) throws StripeException {
        Customer existingCustomer = findCustomerByEmail(email);
        if (existingCustomer != null) {
            return existingCustomer;
        }
        return createCustomer(email, name);
    }

    private Customer findCustomerByEmail(String email) throws StripeException {
        Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        params.put("limit", 1);

        //Fetching customer details via Stripe API
        CustomerCollection customers = Customer.list(params);
        if (!customers.getData().isEmpty()) {
            return customers.getData().getFirst();
        }

        return null;
    }

    private Customer createCustomer(String email, String name) throws StripeException {
        // Create the new customer using Stripe's API
        CustomerCreateParams createParams = CustomerCreateParams.builder()
                .setEmail(email)
                .setName(name)
                .build();

        return Customer.create(createParams);
    }
}
