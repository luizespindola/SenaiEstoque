/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.TipoUsuario;
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
public class TipoUsuarioDao {
    
     public TipoUsuario insert(TipoUsuario tipoUsuario){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(tipoUsuario);
        session.getTransaction().commit();
        session.close();
        return tipoUsuario;
    }
    
    public void delete(TipoUsuario tipoUsuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(tipoUsuario);
        session.getTransaction().commit();
        session.close();
    }
    
    public void update(TipoUsuario tipoUsuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(tipoUsuario);
        session.getTransaction().commit();
        session.close();
    }

    public TipoUsuario getById(Integer id) {
        TipoUsuario tipoUsuario = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        tipoUsuario = (TipoUsuario) session.get(TipoUsuario.class, id);
        session.getTransaction().commit();
        return tipoUsuario;
    }


    public List<TipoUsuario> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT t FROM TipoUsuario t");
        return query.list();
    }
    
}
