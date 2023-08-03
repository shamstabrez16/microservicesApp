package com.mircoservices.inventorymanagementservice.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    Supplier<String> s=()-> "Hello world";

    @GetMapping("/hello")
    public ResponseEntity<String> getHelloWorld(){
        return ResponseEntity.ok(s.get());
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<String> getTicketId(@PathVariable String ticketId){
        return ResponseEntity.ok("this is from InventoryManagement "+ticketId);
    }
}
