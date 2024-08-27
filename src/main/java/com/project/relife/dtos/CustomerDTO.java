package com.project.relife.dtos;

import com.project.relife.entities.CustomerEntity;
import com.project.relife.exceptions.RelifeException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Long customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;

    public static CustomerDTO createDTO(CustomerEntity customerEntity) throws RelifeException {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customerEntity.getCustomerId());
        customerDTO.setCustomerName(customerEntity.getCustomerName());
        customerDTO.setCustomerAddress(customerEntity.getCustomerAddress());
        customerDTO.setCustomerPhone(customerEntity.getCustomerPhone());
        customerDTO.setCustomerEmail(customerEntity.getCustomerEmail());
        return customerDTO;
    }
}
