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

    public String insert(Produto produto) {
        if (produtoDao.insert(produto)!= null) {
            return "Salvo com sucesso";
        } else {
            return "Não foi possível cadastrar novo produto";
        }
    }

    public String delete(Produto produto) {
        if (produtoDao.delete(produto) == true) {
            return "Removido com sucesso";
        } else {
            return "Não foi possível remover produto";
        }
    }

    public String update(Produto produto){
        if (produtoDao.update(produto) == true) {
            return "Atualizado com sucesso";
        } else {
            return "Não foi possível atualizar produto";
        }
    }

    public Produto getById(int id) {
        return produtoDao.getById(id);
    }
     
    public List<Produto> getAll() {
        return produtoDao.getAll();
    }
    
}
