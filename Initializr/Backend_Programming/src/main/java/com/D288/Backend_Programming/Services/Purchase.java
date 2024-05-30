package com.D288.Backend_Programming.Services;

import com.D288.Backend_Programming.entities.Cart;
import com.D288.Backend_Programming.entities.CartItem;
import com.D288.Backend_Programming.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
