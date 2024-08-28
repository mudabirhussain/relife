package com.project.relife.services;

import com.project.relife.dtos.CustomerDTO;
import com.project.relife.entities.CustomerEntity;
import com.project.relife.repositories.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepo customerRepo;

    public CustomerDTO getCustomerById(CustomerDTO customerDTO) throws RuntimeException {
        CustomerEntity customerEntity = customerRepo
                .findById(customerDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return CustomerDTO.fromEntity(customerEntity);
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) throws Exception {
        Optional<CustomerEntity> customerEntityOptional = customerRepo.findById(customerDTO.getCustomerId());

        if(customerEntityOptional.isPresent()){
            throw new Exception("Customer already exists");
        }
        return CustomerDTO.fromEntity(customerRepo.save(CustomerEntity.fromDTO(customerDTO)));
    }
}
