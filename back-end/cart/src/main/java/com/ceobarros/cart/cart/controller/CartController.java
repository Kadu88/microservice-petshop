package com.ceobarros.cart.cart.controller;

import com.ceobarros.cart.cart.model.Cart;
import com.ceobarros.cart.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
    webServerFactoryCustomizer() {
        return factory -> factory.setContextPath("/cart");
    }

    @RequestMapping(value = "add-cart", method = RequestMethod.POST)
    public void addCart(@RequestParam("id-user") Integer idUser) {
        cartService.addCart(idUser);
    }

    @RequestMapping(value = "get-cart-by-id-cart", method = RequestMethod.GET )
    @ResponseBody
    public Cart findByIdCart(@RequestParam("id-cart") Integer idCart) {
        return cartService.getCartByIdCart(idCart);
    }

    @RequestMapping(value = "get-cart-by-id-user", method = RequestMethod.GET )
    @ResponseBody
    public Cart findByIdUser(@RequestParam("id-user") Integer idUser) { return cartService.getCartByIdUser(idUser);
    }



}
