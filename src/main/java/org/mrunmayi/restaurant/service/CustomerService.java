package org.mrunmayi.restaurant.service;

import lombok.RequiredArgsConstructor;
import org.mrunmayi.restaurant.dto.CustomerRequest;
import org.mrunmayi.restaurant.dto.CustomerResponse;
import org.mrunmayi.restaurant.entity.Customer;
import org.mrunmayi.restaurant.mapper.CustomerMapper;
import org.mrunmayi.restaurant.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo repo;
    private final CustomerMapper mapper;

    public String createCustomer(CustomerRequest request) {
        Customer customer = mapper.toEntity(request);
        repo.save(customer);
        return "Customer Created";
    }

    public List<CustomerResponse> getAllCustomers(){
        List<Customer> allCustomers = repo.findAll();
        return allCustomers.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

}
