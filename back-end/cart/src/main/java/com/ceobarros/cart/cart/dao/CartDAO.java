//package com.ceobarros.cart.cart.dao;
//
//import com.ceobarros.cart.cart.model.Cart;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.*;
//
//@Component
//public class CartDAO {
////
////    @PersistenceContext
////    protected EntityManager entityManager;
////
////    public Cart findCartByIdUser(Integer idUser) {
////        try {
////
////
////            Query query = entityManager.createNativeQuery("SELECT * FROM tb_cart c WHERE c.id_user = :idUser").setParameter(1, idUser);
////
////
////        }
////    }
//
//
//
//    //    public Iterable<Produto> findAll() {
////        Iterable<Produto> listaProdutos;
////        try {
//////            List<Produto> listProdutos = entityManager.createNativeQuery("SELECT pro.id_produto, pro.nome, pro.descricao, pro.categoria, pro.quantidade FROM tb_produto pro ").getResultList();
////
////            List<Produto> listProdutos = entityManager.createNativeQuery("SELECT pro.id_produto, pro.nome, pro.descricao, pro.categoria, pro.quantidade FROM tb_produto pro ").getResultList();
////            listaProdutos =  listProdutos.isEmpty() ? null : listProdutos;
////        } catch (NoResultException | NonUniqueResultException e) {
////            listaProdutos = null;
////        }
////        return listaProdutos;
////    }
//
//}
