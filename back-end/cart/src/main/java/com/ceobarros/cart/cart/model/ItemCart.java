package com.ceobarros.cart.cart.model;

import com.ceobarros.cart.cart.converters.LocalDateTimeConverter;
import com.ceobarros.cart.cart.resolvers.EntityIdResolver;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    //@ManyToOne
    //@JoinColumn(name = "id_cart_fk")
    //private Cart cart;

    @Column(name = "id_cart_fk")
    private Integer idCart;

    @Column(name = "id_product")
    private Integer idProduct;

    @Column(name = "product_value", precision=8, scale=2)
    @Digits(integer=8, fraction=2)
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    BigDecimal productValue;

    @Column(name = "discount_percentage", precision=8, scale=2)
    @Digits(integer=8, fraction=2)
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    BigDecimal discountPercentage;

    @Column(name = "promotion_value", precision=8, scale=2)
    @Digits(integer=8, fraction=2)
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    BigDecimal promotionValue;

    @Column(name = "final_product_value", precision=8, scale=2)
    @Digits(integer=8, fraction=2)
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    BigDecimal finalProductValue;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total_final_item_value", precision=8, scale=2)
    @Digits(integer=8, fraction=2)
    @JsonFormat(shape=JsonFormat.Shape.STRING)
    BigDecimal totalFinalItemValue;

    @Column(name = "last_change_date")
    @Convert(converter = LocalDateTimeConverter.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime lastChangeDate;

    public ItemCart() {
    }

    public ItemCart(Integer idCart, Integer idProduct, @Digits(integer = 8, fraction = 2) BigDecimal productValue) {
        this.idCart = idCart;
        this.idProduct = idProduct;
        this.productValue = productValue;
    }

    public ItemCart(Integer idCart, Integer idProduct,
                    @Digits(integer = 8, fraction = 2) BigDecimal productValue,
                    @Digits(integer = 8, fraction = 2) BigDecimal discountPercentage,
                    @Digits(integer = 8, fraction = 2) BigDecimal promotionValue,
                    @Digits(integer = 8, fraction = 2) BigDecimal finalProductValue, Integer quantity,
                    @Digits(integer = 8, fraction = 2) BigDecimal totalFinalItemValue, LocalDateTime lastChangeDate) {
        this.idCart = idCart;
        this.idProduct = idProduct;
        this.productValue = productValue;
        this.discountPercentage = discountPercentage;
        this.promotionValue = promotionValue;
        this.finalProductValue = finalProductValue;
        this.quantity = quantity;
        this.totalFinalItemValue = totalFinalItemValue;
        this.lastChangeDate = lastChangeDate;
    }

    public Integer getIdItemShoppingCart() {
        return idItemShoppingCart;
    }

    public void setIdItemShoppingCart(Integer idItemShoppingCart) {
        this.idItemShoppingCart = idItemShoppingCart;
    }

    public Integer getIdCart() {
        return idCart;
    }

    public void setCart(Integer idCart) {
        this.idCart = idCart;
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

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public BigDecimal getPromotionValue() {
        return promotionValue;
    }

    public void setPromotionValue(BigDecimal promotionValue) {
        this.promotionValue = promotionValue;
    }

    public BigDecimal getFinalProductValue() {
        return finalProductValue;
    }

    public void setFinalProductValue(BigDecimal finalProductValue) {
        this.finalProductValue = finalProductValue;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalFinalItemValue() {
        return totalFinalItemValue;
    }

    public void setTotalFinalItemValue(BigDecimal totalFinalItemValue) {
        this.totalFinalItemValue = totalFinalItemValue;
    }

    public LocalDateTime getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(LocalDateTime lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}
