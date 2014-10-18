/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.Produto;
import br.com.senai.senaiEstoque.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luiz_espindola
 */
public class ProdutoDao {
    
    public Produto insert(Produto produto){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(produto);
        session.getTransaction().commit();
        session.close();
        return produto;
    }
    
    public void delete(Produto produto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(produto);
        session.getTransaction().commit();
        session.close();
    }
    
    public void update(Produto produto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(produto);
        session.getTransaction().commit();
        session.close();
    }

    public Produto getById(Integer id) {
        Produto produto = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        produto = (Produto) session.get(Produto.class, id);
        session.getTransaction().commit();
        session.close();
        return produto;
    }


    public List<Produto> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT p FROM Produto p");
        return query.list();
    }
    
}
