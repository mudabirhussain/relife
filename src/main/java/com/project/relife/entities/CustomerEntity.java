package com.project.relife.entities;

import com.project.relife.dtos.CustomerDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;

    public static CustomerEntity createEntity(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerName(customerDTO.getCustomerName());
        customerEntity.setCustomerEmail(customerDTO.getCustomerEmail());
        customerEntity.setCustomerPhone(customerDTO.getCustomerPhone());
        customerEntity.setCustomerAddress(customerDTO.getCustomerAddress());
        return customerEntity;
    }
}
