package com.ceobarros.cart.cart.repository;

import com.ceobarros.cart.cart.model.ItemCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ItemCartRepository extends CrudRepository<ItemCart, Integer>, QueryByExampleExecutor<ItemCart> {
}
