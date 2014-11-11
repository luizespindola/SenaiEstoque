/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.Entrada;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luiz_espindola
 */
public class EntradaDao {

    public boolean salvar(Entrada entrada) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(entrada);
        try {
            session.getTransaction().commit();
        } catch (Exception ex) {
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public boolean delete(Entrada entrada) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(entrada);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Entrada getById(Integer id) {
        Entrada entrada = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        entrada = (Entrada) session.get(Entrada.class, id);
        session.getTransaction().commit();
        session.close();
        return entrada;
    }

    public List<Entrada> getAll() {
        List<Entrada> listaEntradas=new ArrayList<Entrada>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT e FROM Entrada e");
        listaEntradas=query.list();
        session.close();
        return listaEntradas;
    }
    
    public List<Entrada> getAllByIdProduto(Integer id) {
        List<Entrada> listaEntrada = new ArrayList<Entrada>();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Query query = session.createQuery("FROM Entrada WHERE produto_id = :id");
        query.setParameter("id", id);
        
        listaEntrada = query.list();

        session.close();
        return listaEntrada;
    }

}
