package com.ceobarros.cart.cart.service;

import com.ceobarros.cart.cart.model.Cart;
import com.ceobarros.cart.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;


    public Cart getCartByIdCart(Integer idCart) {
        Optional<Cart> existingCart = cartRepository.findById(idCart);
        return existingCart.orElse(null);

    }

    public Cart getCartByIdUser(Integer idUser) {
        return cartRepository.findCartByIdUser(idUser);
    }

    public void addCart(Integer idUser) {
        try {
            Cart cart = cartRepository.findCartByIdUser(idUser);
            Cart cartCandidate = new Cart();
            cartCandidate.setIdUser(idUser);
            cartCandidate.setCreationDate(LocalDateTime.now());
            cartCandidate = cart != null ? cart : cartCandidate;
            cartCandidate.setLastChangeDate(LocalDateTime.now());
            cartRepository.save(cartCandidate);
        } catch (Exception e) {
            System.out.println("Erro no addCart");
        }
    }

}
