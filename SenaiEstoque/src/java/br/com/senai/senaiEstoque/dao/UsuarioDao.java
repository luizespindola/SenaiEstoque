/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.Usuario;
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
public class UsuarioDao {
    
     public Usuario insert(Usuario usuario){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(usuario);
        session.getTransaction().commit();
        return usuario;
    }
    
    public void delete(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(usuario);
        session.getTransaction().commit();
        session.close();
    }
    
    public void update(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(usuario);
        session.getTransaction().commit();
        session.close();
    }

    public Usuario getById(Integer id) {
        Usuario usuario = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        usuario = (Usuario) session.get(Usuario.class, id);
        session.getTransaction().commit();
        return usuario;
    }


    public List<Usuario> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT u FROM Usuario u");
        return query.list();
    }
        
}
