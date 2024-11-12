package org.mrunmayi.restaurant.service;

import lombok.RequiredArgsConstructor;
import org.mrunmayi.restaurant.dto.CustomerRequest;
import org.mrunmayi.restaurant.dto.CustomerResponse;
import org.mrunmayi.restaurant.entity.Customer;
import org.mrunmayi.restaurant.exception.CustomerNotFoundException;
import org.mrunmayi.restaurant.mapper.CustomerMapper;
import org.mrunmayi.restaurant.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.String.format;

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

    public CustomerResponse getCustomerByEmail(String email) {
        Customer customer = repo.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update Customer:: No customer found with the provided ID:: %s", email)
                ));
        return mapper.toCustomerResponse(customer);

    }

}
