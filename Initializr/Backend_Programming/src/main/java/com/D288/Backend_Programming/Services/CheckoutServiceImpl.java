package com.D288.Backend_Programming.Services;

import com.D288.Backend_Programming.DAO.CartItemRepository;
import com.D288.Backend_Programming.DAO.CartRepository;
import com.D288.Backend_Programming.DAO.CustomerRepository;
import com.D288.Backend_Programming.entities.Cart;
import com.D288.Backend_Programming.entities.CartItem;
import com.D288.Backend_Programming.entities.Customer;
import com.D288.Backend_Programming.entities.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();

        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(cartItem -> {
            cart.add(cartItem);
            cartItem.setCart(cart);
            cartItemRepository.save(cartItem);
        });
        customerRepository.save(customer);
        cartRepository.save(cart);
        cartItemRepository.saveAll(cartItems);

        cart.setStatus(StatusType.ordered);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
