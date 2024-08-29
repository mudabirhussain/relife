package com.project.relife.services;

import com.project.relife.dtos.CustomerDTO;
import com.project.relife.dtos.ProductDTO;
import com.project.relife.dtos.requests.CartRequest;
import com.project.relife.dtos.requests.ProductRequest;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CheckoutSessionService {
    private final ProductService productService;
    private final CustomerService customerService;
    private final StripeCustomerService stripeCustomerService;

    public CheckoutSessionService(
            ProductService productService, CustomerService customerService,
            StripeCustomerService stripeCustomerService
    ) {
        this.productService = productService;
        this.customerService = customerService;
        this.stripeCustomerService = stripeCustomerService;
    }

    public SessionCreateParams createSessionParams(CartRequest cartRequest, String clientBaseUrl) throws StripeException {

        //Validating Customer
        CustomerDTO requestedCustomerDTO = cartRequest.getCustomerDTO();
        CustomerDTO customerDTO = customerService.getCustomerById(requestedCustomerDTO);

        Customer customer = stripeCustomerService.findOrCreateCustomer(customerDTO.getCustomerEmail(), customerDTO.getCustomerName());
        List<ProductRequest> productsRequest = cartRequest.getProductRequest();

        //Setting sessions params for Customer & Redirection URL
        SessionCreateParams.Builder paramsBuilder = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setCustomer(customer.getId())
                .setSuccessUrl(clientBaseUrl + "/success?session_id={CHECKOUT_SESSION_ID}")
                .setCancelUrl(clientBaseUrl + "/failure");

        productsRequest.forEach(productRequest -> {
            paramsBuilder.addLineItem(createLineItem(productRequest));
        });

        return paramsBuilder.build();
    }

    private SessionCreateParams.LineItem createLineItem(ProductRequest productRequest) throws RuntimeException{

        //Checking Quantity
        Long productQuantity = productRequest.getProductQuantity();
        //Validating Products: In future, we will add (inventory Validation
        ProductDTO productDTO = productService.getProductById(productRequest.getProductId());
        Long productPriceCents = convertDollarToCents(productDTO.getProductPrice());

        //Setting Session Params for Products & Return
        return SessionCreateParams.LineItem.builder()
                .setQuantity(productQuantity)
                .setPriceData(
                        SessionCreateParams.LineItem.PriceData.builder()
                                .setProductData(
                                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                .putMetadata("app_id", productDTO.getProductId().toString())
                                                .setName(productDTO.getProductName())
                                                .build()
                                )
                                .setCurrency(productDTO.getProductPriceCurrency())
                                .setUnitAmountDecimal(BigDecimal.valueOf(productPriceCents))
                                .build())
                .build();
    }

    private Long convertDollarToCents(Long usdDollarPrice){
        return usdDollarPrice*100;
    }
}
