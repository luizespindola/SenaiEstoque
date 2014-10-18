/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.Saida;
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
public class SaidaDao {
    
     public Saida insert(Saida saida){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(saida);
        session.getTransaction().commit();
        session.close();
        return saida;
    }
    
    public void delete(Saida saida) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(saida);
        session.getTransaction().commit();
        session.close();
    }
    
    public void update(Saida saida) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(saida);
        session.getTransaction().commit();
        session.close();
    }

    public Saida getById(Integer id) {
        Saida saida = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        saida = (Saida) session.get(Saida.class, id);
        session.getTransaction().commit();
        session.close();
        return saida;
    }


    public List<Saida> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT s FROM Saida s");
        return query.list();
    }
    
}
