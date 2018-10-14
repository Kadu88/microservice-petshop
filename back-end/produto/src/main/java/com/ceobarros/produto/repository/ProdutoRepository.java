package com.ceobarros.produto.repository;

import com.ceobarros.produto.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
