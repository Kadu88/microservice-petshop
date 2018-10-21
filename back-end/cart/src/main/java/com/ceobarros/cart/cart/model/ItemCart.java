package com.ceobarros.cart.cart.model;

import com.ceobarros.cart.cart.resolvers.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Component
@Entity(name = "item_cart")
@Table(name = "tb_item_shopping_cart", schema = "pet_data_cart")
@JsonInclude(content = JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idItemShoppingCart", resolver = EntityIdResolver.class, scope = ItemCart.class)
public class ItemCart implements Serializable {

    private static final long serialVersionUID = -8180836875856408267L;

    @Id
    @Column(name = "id_item_shopping_cart")
    @SequenceGenerator(name = "sq_item_cart", sequenceName = "sq_item_cart", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_item_cart")
    private Integer idItemShoppingCart;

    @ManyToOne
    private Cart cart;

    @Column(name = "id_product")
    private Integer idProduct;

    @Column(name = "product_value")
    BigDecimal productValue;

//    @Column(name = "promotion_value")
//    String promotionValue;

//    @Column(name = "percentual_desconto")

    //    promotion_value
//            percentual_desconto
//    last_change_date
//            quantity
//    final_product_value


    public ItemCart() {
    }

    public ItemCart(Cart cart, Integer idProduct, BigDecimal productValue) {
        this.cart = cart;
        this.idProduct = idProduct;
        this.productValue = productValue;
    }

    public Integer getIdItemShoppingCart() {
        return idItemShoppingCart;
    }

    public void setIdItemShoppingCart(Integer idItemShoppingCart) {
        this.idItemShoppingCart = idItemShoppingCart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public BigDecimal getProductValue() {
        return productValue;
    }

    public void setProductValue(BigDecimal productValue) {
        this.productValue = productValue;
    }
}
