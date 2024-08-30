package com.project.relife.dtos;

import com.project.relife.entities.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private Long customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;

    public static CustomerDTO fromEntity(CustomerEntity customerEntity){
        Objects.requireNonNull(customerEntity, "customerEntity cannot be null");
        return CustomerDTO.builder()
                .customerId(customerEntity.getCustomerId())
                .customerName(customerEntity.getCustomerName())
                .customerAddress(customerEntity.getCustomerAddress())
                .customerPhone(customerEntity.getCustomerPhone())
                .customerEmail(customerEntity.getCustomerEmail())
                .build();
    }
}
