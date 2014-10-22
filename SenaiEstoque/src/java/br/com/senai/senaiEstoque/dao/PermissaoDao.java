/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.Permissao;
import com.mchange.v2.c3p0.C3P0Registry;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author luiz_espindola
 */
public class PermissaoDao {
    
     public Permissao insert(Permissao permissao){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(permissao);
        session.getTransaction().commit();
        session.close();
        return permissao;
    }
    
    public boolean delete(Permissao permissao) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(permissao);
        session.getTransaction().commit();
        session.close();
        return true;
    }
    
    public boolean update(Permissao permissao) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(permissao);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Permissao getById(Integer id) {
        Permissao permissao = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        permissao = (Permissao) session.get(Permissao.class, id);
        session.getTransaction().commit();
        session.close();
        return permissao;
    }


    public List<Permissao> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT p FROM Permissao p");
        return query.list();
    }
    
}
