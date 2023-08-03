package com.mircoservices.ticketingservice.controller;

import com.mircoservices.ticketingservice.customexception.FallbackException;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetrySynchronizationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;
import java.util.function.Supplier;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    Supplier<String> s = ()-> "Hello From Ticketing System  ";

    @GetMapping("/hello")
    public ResponseEntity<String> getHello(){
        return ResponseEntity.ok(s.get());
    }
    private final RestTemplate restTemplate ;

    public TicketController(RestTemplate restTemplate){
        this.restTemplate =restTemplate;
    }


    @Recover
    public ResponseEntity<String> recoverGetTicket(RuntimeException ex, @PathVariable String ticketId) {
        System.out.println("Dependent MicroService Failed");
        return ResponseEntity.ok("Fallback response");
    }
    @GetMapping("/{ticketId}")
    @Retryable(maxAttempts = 3, value = { RuntimeException.class })
    public ResponseEntity<String> getTicket(@PathVariable String ticketId) throws RuntimeException {
        int attempt = RetrySynchronizationManager.getContext().getRetryCount() + 1;
        System.out.println("Retry attempt: " + attempt);
        ResponseEntity<String> response = null;
        //    String inventoryServiceUrl = "http://host.docker.internal:8082/api"; // Service name in Eureka
        String inventoryServiceUrl = "http://Superman.lan:8082/";
            response = restTemplate.exchange(
                    inventoryServiceUrl + "api/inventory/" + ticketId,
                    HttpMethod.GET,
                    null,
                    String.class
            );
        assert response != null;
        String s1 = response.getBody() + " Adding Ticketing values ";

        System.out.println("No Exception occurred");
        System.out.println("s1");

        return ResponseEntity.ok((s1));

    }
}
