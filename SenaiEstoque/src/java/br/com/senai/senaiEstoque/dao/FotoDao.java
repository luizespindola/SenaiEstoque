/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.Foto;
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
public class FotoDao {
    
      public Foto insert(Foto foto){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(foto);
        session.getTransaction().commit();
        session.close();
        return foto;
    }
    
    public void delete(Foto foto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(foto);
        session.getTransaction().commit();
        session.close();
    }
    
    public void update(Foto foto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(foto);
        session.getTransaction().commit();
        session.close();
    }

    public Foto getById(Integer id) {
        Foto foto = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        foto = (Foto) session.get(Foto.class, id);
        session.getTransaction().commit();
        session.close();
        return foto;
    }


    public List<Foto> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT f FROM Foto f");
        return query.list();
    }
    
}
