package com.example.p2pcom.controller;

import com.example.p2pcom.model.Subscriber;
import com.example.p2pcom.service.BuyerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/buyer")
public class BuyerController {
    private final BuyerService buyerService;

    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @PutMapping("/subscribe")
    public ResponseEntity<Subscriber> subscribe(@RequestParam String category) {
        var subscriber = buyerService.subscribe(category);
        return ResponseEntity.ok(subscriber);
    }
}
