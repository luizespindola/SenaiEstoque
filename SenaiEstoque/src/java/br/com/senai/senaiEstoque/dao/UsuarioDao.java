/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.Usuario;
import br.com.senai.senaiEstoque.hibernate.HibernateUtil;
import java.util.ArrayList;
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
        session.close();
        return usuario;
    }
    
    public boolean delete(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(usuario);
        session.getTransaction().commit();
        session.close();
        return true;
    }
    
    public boolean update(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(usuario);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Usuario getById(Integer id) {
        Usuario usuario = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        usuario = (Usuario) session.get(Usuario.class, id);
        session.getTransaction().commit();
        session.close();
        return usuario;
    }


    public List<Usuario> getAll() {
        List<Usuario> listaUsuarios=new ArrayList<Usuario>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT u FROM Usuario u");
        listaUsuarios=query.list();
        session.close();
        return listaUsuarios;
    }
        
}
