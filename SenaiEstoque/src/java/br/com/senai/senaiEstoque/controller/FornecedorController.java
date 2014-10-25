/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.FornecedorDao;
import br.com.senai.senaiEstoque.entity.Fornecedor;
import java.util.List;

/**
 *
 * @author User
 */
public class FornecedorController {
    
    private final FornecedorDao fornecedorDao = new FornecedorDao();

    public boolean insert(Fornecedor fornecedor) {
        if (fornecedorDao.insert(fornecedor) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Fornecedor fornecedor) {
        if (fornecedorDao.delete(fornecedor) == true) {
            return true;
        } else {
            return false;
        }
    }

    public Fornecedor getById(int id) {
        return fornecedorDao.getById(id);
    }

    public List<Fornecedor> getAll() {
        return fornecedorDao.getAll();
    }
    
}
