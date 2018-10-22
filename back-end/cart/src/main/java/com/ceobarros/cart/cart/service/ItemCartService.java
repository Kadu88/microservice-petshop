package com.ceobarros.cart.cart.service;

import com.ceobarros.cart.cart.model.ItemCart;
import com.ceobarros.cart.cart.repository.ItemCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class ItemCartService {

    @Autowired
    ItemCartRepository itemCartRepository;

    public void cleanCartByIdCart(Integer idCart) {
        itemCartRepository.deleteItemCartByIdCart(idCart);
    }

    public void addItemCart(Integer idCart, Integer idProduct,
                            BigDecimal productValue, BigDecimal discountPercentage,
                            BigDecimal promotionValue, BigDecimal finalProductValue,
                            Integer quantity, BigDecimal totalFinalItemValue) {
        ItemCart itemCart = new ItemCart(idCart, idProduct, productValue, discountPercentage, promotionValue,
                finalProductValue, quantity, totalFinalItemValue, LocalDateTime.now());
        itemCartRepository.save(itemCart);
    }

    public Iterable<ItemCart> findAllItemCart() {
        return itemCartRepository.findAll();
    }

    public Iterable<ItemCart> findAllItemByIdCart(Integer idCart) {
        return itemCartRepository.selectItemCartByIdCart(idCart);
    }
}
