/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.ProdutoDao;
import br.com.senai.senaiEstoque.entity.Produto;
import java.util.List;

/**
 *
 * @author User
 */
public class ProdutoController {
    
    private final ProdutoDao produtoDao = new ProdutoDao();

    public boolean salvar(Produto produto) {
        if (produtoDao.salvar(produto) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Produto produto) {
        if (produtoDao.delete(produto) == true) {
            return true;
        } else {
            return false;
        }
    }

    public Produto getById(int id) {
        return produtoDao.getById(id);
    }
     
    public List<Produto> getAll() {
        return produtoDao.getAll();
    }
    
}
