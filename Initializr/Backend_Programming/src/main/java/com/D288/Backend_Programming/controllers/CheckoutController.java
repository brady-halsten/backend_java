package com.D288.Backend_Programming.controllers;

import com.D288.Backend_Programming.Services.CheckoutService;
import com.D288.Backend_Programming.Services.Purchase;
import com.D288.Backend_Programming.Services.PurchaseResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin("http://localhost:4200")
public class CheckoutController {


    @Autowired
    private CheckoutService checkoutService;

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@Valid @RequestBody Purchase purchase) {

        PurchaseResponse savedPurchase = checkoutService.placeOrder(purchase);

        //PurchaseResponse = new PurchaseResponse(savedPurchase.getCart().getOrderTrackingNumber());

        return savedPurchase;
    }


}
