/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.EntradaDao;
import br.com.senai.senaiEstoque.entity.Entrada;
import java.util.List;

/**
 *
 * @author User
 */
public class EntradaController {
        
    private final EntradaDao entradaDao = new EntradaDao();

    public boolean insert(Entrada entrada) {
        if (entradaDao.insert(entrada) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Entrada entrada) {
        if (entradaDao.delete(entrada) == true) {
            return true;
        } else {
            return false;
        }
    }

    public Entrada getById(int id) {
        return entradaDao.getById(id);
    }

    public List<Entrada> getAll() {
        return entradaDao.getAll();
    }
    
    public List<Entrada> getAllByIdProduto(Integer id) {
        return entradaDao.getAllByIdProduto(id);
    }
}

    
