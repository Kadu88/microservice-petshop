package com.ceobarros.cart.cart.service;

import com.ceobarros.cart.cart.repository.ItemCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCartService {

    @Autowired
    ItemCartRepository itemCartRepository;

    public void cleanCartByIdCart(Integer idCart) {
        itemCartRepository.deleteItemCartByIdCart(idCart);
    }

    public void cleanCartByIdUser(Integer idUser) {
        itemCartRepository.deleteItemCartByIdUser(idUser);
    }
}
