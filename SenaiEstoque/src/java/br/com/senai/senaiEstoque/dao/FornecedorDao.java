/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.Fornecedor;
import br.com.senai.senaiEstoque.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luiz_espindola
 */
public class FornecedorDao {
    
       public Fornecedor insert(Fornecedor fornecedor){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(fornecedor);
        session.getTransaction().commit();
        session.close();
        return fornecedor;
    }
    
    public void delete(Fornecedor fornecedor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(fornecedor);
        session.getTransaction().commit();
        session.close();
    }
    
    public void update(Fornecedor fornecedor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(fornecedor);
        session.getTransaction().commit();
        session.close();
    }

    public Fornecedor getById(Integer id) {
        Fornecedor fornecedor = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        fornecedor = (Fornecedor) session.get(Fornecedor.class, id);
        session.getTransaction().commit();
        return fornecedor;
    }


    public List<Fornecedor> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT f FROM Fornecedor f");
        return query.list();
    }
    
}
