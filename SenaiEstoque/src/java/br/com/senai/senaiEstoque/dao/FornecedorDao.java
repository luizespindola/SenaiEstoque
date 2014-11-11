/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luiz_espindola
 */
public class FornecedorDao {

    public boolean salvar(Fornecedor fornecedor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(fornecedor);
        try {
            session.getTransaction().commit();
        } catch (Exception ex) {
            return false;
        } finally {
           session.close();
        }
        return true;
    }

    public boolean delete(Fornecedor fornecedor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(fornecedor);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Fornecedor getById(Integer id) {
        Fornecedor fornecedor = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        fornecedor = (Fornecedor) session.get(Fornecedor.class, id);
        session.getTransaction().commit();
        session.close();
        return fornecedor;
    }

    public List<Fornecedor> getAll() {
        List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT f FROM Fornecedor f");
        listaFornecedor = query.list();
        session.close();
        return listaFornecedor;
    }

}
