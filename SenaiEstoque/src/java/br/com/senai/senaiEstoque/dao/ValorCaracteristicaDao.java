/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.ValorCaracteristica;
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
public class ValorCaracteristicaDao {
    
     public ValorCaracteristica insert(ValorCaracteristica valorCaracteristica){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        //Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(valorCaracteristica);
        session.getTransaction().commit();
        return valorCaracteristica;
    }
    
    public void delete(ValorCaracteristica valorCaracteristica) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(valorCaracteristica);
        session.getTransaction().commit();
        session.close();
    }
    
    public void update(ValorCaracteristica valorCaracteristica) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(valorCaracteristica);
        session.getTransaction().commit();
        session.close();
    }

    public ValorCaracteristica getById(Integer id) {
        ValorCaracteristica valorCaracteristica = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        valorCaracteristica = (ValorCaracteristica) session.get(ValorCaracteristica.class, id);
        session.getTransaction().commit();
        return valorCaracteristica;
    }


    public List<ValorCaracteristica> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT v FROM ValorCaracteristica V");
        return query.list();
    }
    
}
