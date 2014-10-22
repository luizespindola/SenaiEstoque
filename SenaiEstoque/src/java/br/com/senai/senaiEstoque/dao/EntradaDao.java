/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.Entrada;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author luiz_espindola
 */
public class EntradaDao {
    
     public Entrada insert(Entrada entrada){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(entrada);
        session.getTransaction().commit();
        session.close();
        return entrada;
    }
    
    public boolean delete(Entrada entrada) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(entrada);
        session.getTransaction().commit();
        session.close();
        return true;
    }
    
    public boolean update(Entrada entrada) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(entrada);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Entrada getById(Integer id) {
        Entrada entrada = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        entrada = (Entrada) session.get(Entrada.class, id);
        session.getTransaction().commit();
        session.close();
        return entrada;
    }


    public List<Entrada> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT e FROM Entrada e");
        return query.list();
    }
    
    
}
