/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.ValorCaracteristica;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luiz_espindola
 */
public class ValorCaracteristicaDao {

    public boolean insert(ValorCaracteristica valorCaracteristica) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(valorCaracteristica);
        try {
            session.getTransaction().commit();
        } catch (Exception ex) {
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public boolean delete(ValorCaracteristica valorCaracteristica) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(valorCaracteristica);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public ValorCaracteristica getById(Integer id) {
        ValorCaracteristica valorCaracteristica = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        valorCaracteristica = (ValorCaracteristica) session.get(ValorCaracteristica.class, id);
        session.getTransaction().commit();
        session.close();
        return valorCaracteristica;
    }

    public List<ValorCaracteristica> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT v FROM ValorCaracteristica V");
        return query.list();
    }

}
