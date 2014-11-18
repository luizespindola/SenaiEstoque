/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.Caracteristica;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luiz_espindola
 */
public class CaracteristicaDao {

    public boolean salvar(Caracteristica caracteristica) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(caracteristica);
        try {
            session.getTransaction().commit();
        } catch (Exception ex) {
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public boolean delete(Caracteristica caracteristica) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(caracteristica);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Caracteristica getById(Integer id) {
        Caracteristica caracteristica = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        caracteristica = (Caracteristica) session.get(Caracteristica.class, id);
        session.getTransaction().commit();
        session.close();
        return caracteristica;
    }

    public List<Caracteristica> getAll() {
        List<Caracteristica> listaCaracteristicas = new ArrayList<Caracteristica>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT c FROM Caracteristica c");
        listaCaracteristicas = query.list();
        session.close();
        return listaCaracteristicas;
    }

}
