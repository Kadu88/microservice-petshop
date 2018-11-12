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
    @Column(name = "image")
    private Blob imageMedia;

    public Image() {
    }

    public Image(Integer idProduct, Blob image_media) {
        this.idProduct = idProduct;
        this.imageMedia = image_media;
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

    public Blob getImageMedia() {
        return imageMedia;
    }

    public void setImageMedia(Blob imageMedia) {
        this.imageMedia = imageMedia;
    }
}
