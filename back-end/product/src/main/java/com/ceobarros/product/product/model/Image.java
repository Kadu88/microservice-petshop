package com.ceobarros.product.product.model;

import com.ceobarros.product.product.resolvers.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Component
@Entity(name = "image")
@Table(name = "tb_image", schema = "pet_data_product")
@JsonInclude(content = JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idImage", resolver = EntityIdResolver.class, scope = Image.class)
public class Image implements Serializable {

    private static final long serialVersionUID = 4400139838647808967L;

    @Id
    @Column(name = "id_image")
    @SequenceGenerator(name = "sq_image", sequenceName = "sq_image", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_image")
    private Integer idImage;

    @Column(name = "id_product")
    private Integer idProduct;

    @Lob
    @Column(name = "image_small")
    private Blob imageSmall;

    @Lob
    @Column(name = "image_medium")
    private Blob imageMedium;

    @Lob
    @Column(name = "image_large")
    private Blob imageLarge;

    public Image() {
    }

    public Image(Integer idProduct, Blob imageMedium) {
        this.idProduct = idProduct;
        this.imageMedium = imageMedium;
    }

    public Image(Integer idProduct, Blob imageSmall, Blob imageMedium, Blob imageLarge) {
        this.idProduct = idProduct;
        this.imageSmall = imageSmall;
        this.imageMedium = imageMedium;
        this.imageLarge = imageLarge;
    }

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Blob getImageSmall() {
        return imageSmall;
    }

    public void setImageSmall(Blob imageSmall) {
        this.imageSmall = imageSmall;
    }

    public Blob getImageMedium() {
        return imageMedium;
    }

    public void setImageMedium(Blob imageMedium) {
        this.imageMedium = imageMedium;
    }

    public Blob getImageLarge() {
        return imageLarge;
    }

    public void setImageLarge(Blob imageLarge) {
        this.imageLarge = imageLarge;
    }
}
