package org.mrunmayi.restaurant.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mrunmayi.restaurant.dto.CustomerRequest;
import org.mrunmayi.restaurant.dto.CustomerResponse;
import org.mrunmayi.restaurant.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

        private final CustomerService customerService;

        @PostMapping("/login")
        public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request) {
            return ResponseEntity.ok(customerService.createCustomer(request));
        }
}
