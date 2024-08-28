package com.project.relife.dtos.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.relife.dtos.CustomerDTO;
import com.project.relife.enums.CurrencyEnum;
import com.project.relife.enums.PaymentMode;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CartRequest {
    private List<ProductRequest> productRequest;
    private CustomerDTO CustomerDTO;
    private CurrencyEnum currencyEnum;
    private Long total;
    private PaymentMode mode;
}
