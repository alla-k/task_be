package com.elinvar.pricehandler.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/addCustomer")
    public ResponseEntity<String> addCustomer(@RequestParam("name") String name, @RequestParam("balance") BigDecimal balance)
    {
        try{
        return ResponseEntity.ok(onboardCustomer(UUID.randomUUID().toString(), name, balance);
        }
        catch (Exception ex){
            log.error(ex.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Creating cclient has failed.");
        }


    }
}
