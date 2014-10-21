/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.FornecedorDao;
import br.com.senai.senaiEstoque.entity.Fornecedor;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author User
 */
@ManagedBean
public class FornecedorController {
    
    private final FornecedorDao fornecedorDao = new FornecedorDao();

    public String insert(Fornecedor fornecedor) {
        if (fornecedorDao.insert(fornecedor) != null) {
            return "Salvo com sucesso";
        } else {
            return "Não foi possível cadastrar novo fornecedor";
        }
    }

    public String delete(Fornecedor fornecedor) {
        if (fornecedorDao.delete(fornecedor) == true) {
            return "Removido com sucesso";
        } else {
            return "Não foi possível remover fornecedor";
        }
    }

    public String update(Fornecedor fornecedor) {
        if (fornecedorDao.update(fornecedor) == true) {
            return "Atualizado com sucesso";
        } else {
            return "Não foi possível atualizar fornecedor";
        }
    }

    public Fornecedor getById(int id) {
        return fornecedorDao.getById(id);
    }

    public List<Fornecedor> getAll() {
        return fornecedorDao.getAll();
    }
    
}
