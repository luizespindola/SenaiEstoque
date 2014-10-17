/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author luiz_espindola
 */
public class Caracteristica {
    
     public Caracteristica insert(Caracteristica caracteristica){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        //Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(caracteristica);
        session.getTransaction().commit();
        return caracteristica;
    }
    
    public void delete(Caracteristica caracteristica) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(caracteristica);
        session.getTransaction().commit();
        session.close();
    }
    
    public void update(Caracteristica caracteristica) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(caracteristica);
        session.getTransaction().commit();
        session.close();
    }

    public Caracteristica getById(Integer id) {
        Caracteristica caracteristica = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        caracteristica = (Caracteristica) session.get(Caracteristica.class, id);
        session.getTransaction().commit();
        return caracteristica;
    }


    public List<Caracteristica> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT c FROM Caracteristica c");
        return query.list();
    }
    
    
}
