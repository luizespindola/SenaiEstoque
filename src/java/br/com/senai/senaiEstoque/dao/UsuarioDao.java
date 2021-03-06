/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luiz_espindola
 */
public class UsuarioDao {

    public boolean salvar(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(usuario);
        try {
            session.getTransaction().commit();
        } catch (Exception ex) {
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public boolean delete(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(usuario);
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
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT u FROM Usuario u");
        listaUsuarios = query.list();
        session.close();
        return listaUsuarios;
    }

}
