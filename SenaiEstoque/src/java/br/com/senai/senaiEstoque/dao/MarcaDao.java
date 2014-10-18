/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.Marca;
import br.com.senai.senaiEstoque.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luiz_espindola
 */
public class MarcaDao {
    
       public Marca insert(Marca marca){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(marca);
        session.getTransaction().commit();
        session.close();
        return marca;
    }
    
    public void delete(Marca marca) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(marca);
        session.getTransaction().commit();
        session.close();
    }
    
    public void update(Marca marca) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(marca);
        session.getTransaction().commit();
        session.close();
    }

    public Marca getById(Integer id) {
        Marca marca = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        marca = (Marca) session.get(Marca.class, id);
        session.getTransaction().commit();
        session.close();
        return marca;
    }


    public List<Marca> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT m FROM Marca m");
        return query.list();
    }
    
}

    

