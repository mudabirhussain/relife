package com.project.relife.dtos;

import com.project.relife.entities.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Long customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;

    public static CustomerDTO fromEntity(CustomerEntity customerEntity){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customerEntity.getCustomerId());
        customerDTO.setCustomerName(customerEntity.getCustomerName());
        customerDTO.setCustomerAddress(customerEntity.getCustomerAddress());
        customerDTO.setCustomerPhone(customerEntity.getCustomerPhone());
        customerDTO.setCustomerEmail(customerEntity.getCustomerEmail());
        return customerDTO;
    }
}
