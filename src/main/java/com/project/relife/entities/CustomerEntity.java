package com.project.relife.entities;

import com.project.relife.dtos.CustomerDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Data
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;

    public static CustomerEntity fromDTO(@NonNull CustomerDTO customerDTO) {
        Objects.requireNonNull(customerDTO, "customerDTO cannot be null");
        return CustomerEntity.builder()
                .customerId(customerDTO.getCustomerId())
                .customerName(customerDTO.getCustomerName())
                .customerEmail(customerDTO.getCustomerEmail())
                .customerPhone(customerDTO.getCustomerPhone())
                .customerAddress(customerDTO.getCustomerAddress())
                .build();
    }
}
