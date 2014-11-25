/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.Caracteristica;
import br.com.senai.senaiEstoque.entity.Produto;
import br.com.senai.senaiEstoque.entity.ValorCaracteristica;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luiz_espindola
 */
public class ValorCaracteristicaDao {

    public boolean salvar(ValorCaracteristica valorCaracteristica) {
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

    public List<ValorCaracteristica> getAllByIdCaracteristica(Integer id) {
        List<ValorCaracteristica> listaValorCaracteristica = new ArrayList<ValorCaracteristica>();

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("FROM ValorCaracteristica WHERE caracteristica_id = :id");
        query.setParameter("id", id);

        listaValorCaracteristica = query.list();

        session.close();
        return listaValorCaracteristica;
    }

    public List<ValorCaracteristica> getAll() {
        List<ValorCaracteristica> listaValorCaracteristica = new ArrayList<ValorCaracteristica>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT v FROM ValorCaracteristica v");
        listaValorCaracteristica = query.list();
        session.close();
        return listaValorCaracteristica;
    }
    
    public List<ValorCaracteristica> getAllByIdCaracteristica(Caracteristica caracteristica) {
        List<ValorCaracteristica> listaValorCaracteristica = new ArrayList<ValorCaracteristica>();

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("FROM ValorCaracteristica WHERE caracteristica_id = :id");
        query.setParameter("id", caracteristica.getId());
        listaValorCaracteristica = query.list();

        session.close();
        return listaValorCaracteristica;
    }
    
     public List<ValorCaracteristica> getAllByIdProduto(Integer id) {
        List<ValorCaracteristica> listaValorCaracteristica = new ArrayList<ValorCaracteristica>();

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("FROM produto_valorcaracteristica WHERE listaProduto_id = :id");
        query.setParameter("id", id);

        listaValorCaracteristica = query.list();

        session.close();
        return listaValorCaracteristica;
    }
     
     public List<ValorCaracteristica> getAllByProduto(Produto produto) {
        List<ValorCaracteristica> listaValorCaracteristica = new ArrayList<ValorCaracteristica>();

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("FROM ValorCaracteristica WHERE ValorCaracteristica.produto = :umProduto");
        query.setParameter("umProduto", produto);

        listaValorCaracteristica = query.list();

        session.close();
        return listaValorCaracteristica;
    }
    

}
