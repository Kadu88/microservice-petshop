package com.ceobarros.product.product.model;

import com.ceobarros.product.product.converters.LocalDateTimeConverter;
import com.ceobarros.product.product.resolvers.EntityIdResolver;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Component
@Entity(name = "product")
@Table(name = "tb_product", schema = "pet_data_product")
@JsonInclude(content = JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProduct", resolver = EntityIdResolver.class, scope = Product.class)
public class Product implements Serializable {

    private static final long serialVersionUID = -6182141251632229978L;

    @Id
    @Column(name = "id_product")
    @SequenceGenerator(name = "sq_product", sequenceName = "sq_product", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_product")
    private Integer idProduct;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "value")
    private String value;

    @Column(name = "id_image")
    private Integer idImage;

    @Column(name = "creation_date")
    @Convert(converter = LocalDateTimeConverter.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime creationDate;

    @Column(name = "last_change_date")
    @Convert(converter = LocalDateTimeConverter.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime lastChangeDate;

    public Product() {
    }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Product(String name, String description, String category, Integer amount, String value, Integer idImage, LocalDateTime creationDate, LocalDateTime lastChangeDate) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.amount = amount;
        this.value = value;
        this.idImage = idImage;
        this.creationDate = creationDate;
        this.lastChangeDate = lastChangeDate;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(LocalDateTime lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}
