package com.ceobarros.produto.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ceobarros.produto.model.Produto;
import com.ceobarros.produto.repository.ProdutoRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ProdutoService implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4447928027024030782L;

	@Autowired
	private ProdutoRepository produtoRepository;

	public Iterable<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto inserirProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

}
