package com.ceobarros.cart.cart.repository;

import com.ceobarros.cart.cart.model.ItemCart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ItemCartRepository extends CrudRepository<ItemCart, Integer>, QueryByExampleExecutor<ItemCart> {

    @Query("DELETE i FROM item_cart i WHERE i.idCart = ?1") void deleteItemCartByIdCart(Integer idCart);

    @Query("DELETE i FROM item_cart i WHERE i.idUser = ?1") void deleteItemCartByIdUser(Integer idUser);

}
