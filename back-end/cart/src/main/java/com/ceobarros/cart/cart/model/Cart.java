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
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Entity(name = "cart")
@Table(name = "tb_cart", schema = "pet_data_cart")
@JsonInclude(content = JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCart", resolver = EntityIdResolver.class, scope = Cart.class)
public class Cart implements Serializable {

    private static final long serialVersionUID = 7919387452344017764L;

    @Id
    @Column(name = "id_cart")
    @SequenceGenerator(name = "sq_cart", sequenceName = "sq_cart", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_cart")
    private int idCart;

    @Column(name = "id_user")
    private int idUser;

    @Column(name = "creation_date")
    @Convert(converter = LocalDateTimeConverter.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime creationDate;

    @Column(name = "payment_sent")
    private Boolean paymentSent;

    @Column(name = "payment_sent_date")
    private LocalDate paymentSentDate;

    @Column(name = "purchase_completed")
    private Boolean purchaseCompleted;

    @Column(name = "purchase_completed_date")
    private LocalDate purchaseCompletedDate;

    @Column(name = "product_shipped")
    private Boolean productShipped;

    @Column(name = "product_shipped_date")
    private LocalDate productShippedDate;

    @Column(name = "last_change_date")
    @Convert(converter = LocalDateTimeConverter.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime lastChangeDate;

    public Cart() {
    }

    public Cart(int idUser, LocalDateTime creationDate, Boolean paymentSent, LocalDate paymentSentDate, Boolean purchaseCompleted, LocalDate purchaseCompletedDate, Boolean productShipped, LocalDate productShippedDate, LocalDateTime lastChangeDate) {
        this.idUser = idUser;
        this.creationDate = creationDate;
        this.paymentSent = paymentSent;
        this.paymentSentDate = paymentSentDate;
        this.purchaseCompleted = purchaseCompleted;
        this.purchaseCompletedDate = purchaseCompletedDate;
        this.productShipped = productShipped;
        this.productShippedDate = productShippedDate;
        this.lastChangeDate = lastChangeDate;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getPaymentSent() {
        return paymentSent;
    }

    public void setPaymentSent(Boolean paymentSent) {
        this.paymentSent = paymentSent;
    }

    public LocalDate getPaymentSentDate() {
        return paymentSentDate;
    }

    public void setPaymentSentDate(LocalDate paymentSentDate) {
        this.paymentSentDate = paymentSentDate;
    }

    public Boolean getPurchaseCompleted() {
        return purchaseCompleted;
    }

    public void setPurchaseCompleted(Boolean purchaseCompleted) {
        this.purchaseCompleted = purchaseCompleted;
    }

    public LocalDate getPurchaseCompletedDate() {
        return purchaseCompletedDate;
    }

    public void setPurchaseCompletedDate(LocalDate purchaseCompletedDate) {
        this.purchaseCompletedDate = purchaseCompletedDate;
    }

    public Boolean getProductShipped() {
        return productShipped;
    }

    public void setProductShipped(Boolean productShipped) {
        this.productShipped = productShipped;
    }

    public LocalDate getProductShippedDate() {
        return productShippedDate;
    }

    public void setProductShippedDate(LocalDate productShippedDate) {
        this.productShippedDate = productShippedDate;
    }

    public LocalDateTime getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(LocalDateTime lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}
