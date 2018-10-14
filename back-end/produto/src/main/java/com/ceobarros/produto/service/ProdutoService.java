package com.ceobarros.produto.service;

import com.ceobarros.produto.dao.ProdutoDao;
import com.ceobarros.produto.model.Produto;
import com.ceobarros.produto.repository.GenericRepository;
import com.ceobarros.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ProdutoService implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4447928027024030782L;

    //@Autowired
   // private ProdutoDao produtoDao;

    @Autowired
    private ProdutoRepository produtoRepository;

//    @Autowired
//    private GenericRepository<Produto> genericRepositoryProduto;

    public Iterable<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto inserirProduto(Produto produto) {
        final Produto produtoSalvo = produtoRepository.save(produto);
        return produtoSalvo;
    }

}

