/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.Cor;
import br.com.senai.senaiEstoque.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luiz_espindola
 */
public class CorDao {  
 
   public Cor insert(Cor cor){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(cor);
        session.getTransaction().commit();
        session.close();
        return cor;
    }
    
    public boolean delete(Cor cor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(cor);
        session.getTransaction().commit();
        session.close();
        return true;
    }
    
    public boolean update(Cor cor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(cor);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Cor getById(Integer id) {
        Cor cor = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        cor = (Cor) session.get(Cor.class, id);
        session.getTransaction().commit();
        session.close();
        return cor;
    }


    public List<Cor> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT c FROM Cor c");
        return query.list();
    } 
}

