package com.ceobarros.cart.cart.controller;

import com.ceobarros.cart.cart.model.Cart;
import com.ceobarros.cart.cart.model.ItemCart;
import com.ceobarros.cart.cart.service.CartService;
import com.ceobarros.cart.cart.service.ItemCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ItemCartService itemCartService;

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

    @RequestMapping(value = "get-all-cart", method = RequestMethod.GET )
    @ResponseBody
    public Iterable<Cart> findAllCart() {
        return cartService.findAllCart();
    }

    @RequestMapping(value = "get-cart-by-id-user", method = RequestMethod.GET )
    @ResponseBody
    public Cart findByIdUser(@RequestParam("id-user") Integer idUser) { return cartService.getCartByIdUser(idUser);
    }

    @RequestMapping(value = "clean-cart-by-id-cart", method = RequestMethod.GET )
    public void cleanCartByIdCart(@RequestParam("id-cart") Integer idCart) { cartService.cleanCartByIdCart(idCart);
    }

    @RequestMapping(value = "clean-cart-by-id-user", method = RequestMethod.GET )
    public void cleanCartByIdUser(@RequestParam("id-user") Integer idUser) { cartService.cleanCartByIdUser(idUser);
    }

    @RequestMapping(value = "get-all-item-cart", method = RequestMethod.GET )
    @ResponseBody
    public Iterable<ItemCart> findAllItem() {
        return itemCartService.findAllItemCart();
    }

    @RequestMapping(value = "get-all-item-cart-by-id-cart", method = RequestMethod.GET )
    @ResponseBody
    public Iterable<ItemCart> findAllItemByIdCart(@RequestParam("id-cart") Integer idCart) {
        return itemCartService.findAllItemByIdCart(idCart);
    }

    @RequestMapping(value = "add-item-cart", method = RequestMethod.POST )
    public void addItemCart(@RequestParam("id-cart") Integer idCart,
                            @RequestParam("id-product") Integer idProduct,
                            @RequestParam("product-value") BigDecimal productValue,
                            @RequestParam("discount-percentage") BigDecimal discountPercentage,
                            @RequestParam("promotion-value") BigDecimal promotionValue,
                            @RequestParam("final-product-value") BigDecimal finalProductValue,
                            @RequestParam("quantity") Integer quantity,
                            @RequestParam("total-final-item-value") BigDecimal totalFinalItemValue) {
        itemCartService.addItemCart(idCart, idProduct, productValue, discountPercentage, promotionValue, finalProductValue, quantity, totalFinalItemValue );
    }


}
