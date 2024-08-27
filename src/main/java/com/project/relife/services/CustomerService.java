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

    public CustomerDTO getCustomerById(CustomerDTO customerDTO) throws Exception {
        CustomerEntity customerEntity = customerRepo
                .findById(customerDTO.getCustomerId())
                .orElseThrow(() -> new Exception("Customer not found"));
        return CustomerDTO.createDTO(customerEntity);
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) throws Exception {
        Optional<CustomerEntity> customerEntityOptional = customerRepo.findById(customerDTO.getCustomerId());

        if(customerEntityOptional.isPresent()){
            throw new Exception("Customer already exists");
        }
        return CustomerDTO.createDTO(customerRepo.save(CustomerEntity.createEntity(customerDTO)));
    }
}
