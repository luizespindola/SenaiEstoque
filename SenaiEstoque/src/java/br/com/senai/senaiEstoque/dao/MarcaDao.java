/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.senaiEstoque.dao;

import br.com.senai.senaiEstoque.entity.Marca;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author luiz_espindola
 */
public class MarcaDao {
    
       public boolean salvar(Marca marca){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(marca);
        try{
            session.getTransaction().commit();
        }catch(Exception ex){
            return false;
        }finally{
            session.close();
        }
        return true;
    }
    
    public boolean delete(Marca marca) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(marca);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Marca getById(Integer id) {
        Marca marca = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        marca = (Marca) session.get(Marca.class, id);
        session.getTransaction().commit();
        session.close();
        return marca;
    }


    public List<Marca> getAll() {
        List<Marca> listaMarcas=new ArrayList<Marca>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT m FROM Marca m");
        listaMarcas=query.list();
        session.close();
        return listaMarcas;
    }
    
}

    

