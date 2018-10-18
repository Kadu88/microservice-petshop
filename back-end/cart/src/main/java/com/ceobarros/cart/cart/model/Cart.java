package com.ceobarros.cart.cart.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "cart")
@Table(name = "tb_cart", schema = "pet_data_cart")
//    @JsonInclude(content = JsonInclude.Include.NON_EMPTY)
//    @JsonIgnoreProperties(ignoreUnknown = true)
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProduto", resolver = EntityIdResolver.class, scope = Produto.class)
public class Cart {



//    /**
//     * The persistent class for the TB_PRODUTO database table.
//     */
//    @Entity(name = "produto")
//    @Table(name = "tb_produto", schema = "pet_data_produto")
//    @JsonInclude(content = JsonInclude.Include.NON_EMPTY)
//    @JsonIgnoreProperties(ignoreUnknown = true)
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProduto", resolver = EntityIdResolver.class, scope = Produto.class)
//    public class Produto implements Serializable {
}
