/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.Foto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luiz_espindola
 */
public class FotoDao {

    public boolean salvar(Foto foto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(foto);
        try {
            session.getTransaction().commit();
        } catch (Exception ex) {
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public boolean delete(Foto foto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(foto);
        session.getTransaction().commit();
        session.close();
        return true;
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
        List<Foto> listaFotos = new ArrayList<Foto>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT f FROM Foto f");
        listaFotos = query.list();
        session.close();
        return listaFotos;
    }

}
