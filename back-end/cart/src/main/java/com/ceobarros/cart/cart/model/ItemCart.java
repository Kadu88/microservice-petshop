package com.ceobarros.cart.cart.model;

import com.ceobarros.cart.cart.resolvers.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity(name = "tb_item_shopping_cart")
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

//    id_product
//            product_value
//    promotion_value
//            percentual_desconto
//    last_change_date
//            quantity
//    final_product_value




}
