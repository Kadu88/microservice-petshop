package com.ceobarros.cart.cart.repository;

import com.ceobarros.cart.cart.model.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer>{

    @Query("SELECT c FROM cart c WHERE c.idUser = ?1") Cart findCartByIdUser(Integer idUser);

}
