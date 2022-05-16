package com.elinvar.pricehandler.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.server.ResponseStatusException;
import com.elinvar.customer.service.OnboardCustomerService;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@RestController
public class CustomerController {

    @Autowired
    OnboardCustomerService onboardCustomerService;

    @GetMapping("/addCustomer")
    public ResponseEntity<String> addCustomer(@RequestParam("name") String name, @RequestParam("balance") BigDecimal balance)
    {
        try{
        return ResponseEntity.ok(onboardCustomerService.onboardCustomer(UUID.randomUUID().toString(), name, balance));
        }
        catch (Exception ex){
            log.error(ex.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Creating cclient has failed.");
        }


    }
}
