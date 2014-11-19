/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.dao;

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
public class ProdutoDao {

    public boolean salvar(Produto produto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(produto);
        try {
            session.getTransaction().commit();
        } catch (Exception ex) {
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public boolean delete(Produto produto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(produto);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Produto getById(Integer id) {
        Produto produto = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        produto = (Produto) session.get(Produto.class, id);
        session.getTransaction().commit();
        session.close();
        return produto;
    }

    public List<Produto> getAll() {
        List<Produto> listaProdutos = new ArrayList<Produto>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT p FROM Produto p");
        listaProdutos = query.list();
        session.close();
        return listaProdutos;
    }

    public List<ValorCaracteristica> getValoresCaracteristicaByProduto(Produto produto) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        produto = (Produto) session.get(Produto.class, produto.getId());
        session.getTransaction().commit();
        session.close();

        return produto.getListaValorCaracteristicas();
    }

}
