/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.TipoUsuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luiz_espindola
 */
public class TipoUsuarioDao {

    public boolean insert(TipoUsuario tipoUsuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(tipoUsuario);
        try {
            session.getTransaction().commit();
        } catch (Exception ex) {
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public boolean delete(TipoUsuario tipoUsuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(tipoUsuario);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public TipoUsuario getById(Integer id) {
        TipoUsuario tipoUsuario = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        tipoUsuario = (TipoUsuario) session.get(TipoUsuario.class, id);
        session.getTransaction().commit();
        session.close();
        return tipoUsuario;
    }

    public List<TipoUsuario> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT t FROM TipoUsuario t");
        return query.list();
    }

}
