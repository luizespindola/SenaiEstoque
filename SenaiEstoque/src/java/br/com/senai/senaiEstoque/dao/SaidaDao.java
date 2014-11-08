/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.Saida;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luiz_espindola
 */
public class SaidaDao {

    public boolean insert(Saida saida) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(saida);
        try {
            session.getTransaction().commit();
        } catch (Exception ex) {
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public boolean delete(Saida saida) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(saida);
        session.getTransaction().commit();
        session.close();
        return true;
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
        List<Saida> listaSaidas=new ArrayList<Saida>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT s FROM Saida s");
        listaSaidas=query.list();
        session.close();
        return listaSaidas;
    }

}
