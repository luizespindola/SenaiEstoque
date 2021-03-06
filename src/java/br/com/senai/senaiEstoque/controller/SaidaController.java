/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.SaidaDao;
import br.com.senai.senaiEstoque.entity.Produto;
import br.com.senai.senaiEstoque.entity.Saida;
import java.util.List;

/**
 *
 * @author User
 */
public class SaidaController {

    private final SaidaDao saidaDao = new SaidaDao();

    public boolean salvar(Saida saida) {
        Integer valor = 0;
        if (saida.getId() != null) {
            valor = saidaDao.getById(saida.getId()).getQuantidade();
        }
        Produto produto = saida.getProduto();
        if (saida.getQuantidade() > produto.getQuantidade()) {
            return false;
        } else {
            if (saidaDao.salvar(saida) == true) {
                produto.setQuantidade(produto.getQuantidade() + valor);
                produto.setQuantidade(produto.getQuantidade() - saida.getQuantidade());
                ProdutoController produtoController = new ProdutoController();
                produtoController.salvar(produto);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean delete(Saida saida) {
        if (saidaDao.delete(saida) == true) {
            Produto produto = saida.getProduto();
            produto.setQuantidade(produto.getQuantidade() + saida.getQuantidade());
            ProdutoController produtoController = new ProdutoController();
            produtoController.salvar(produto);
            return true;
        } else {
            return false;
        }
    }

    public Saida getById(int id) {
        return saidaDao.getById(id);
    }

    public List<Saida> getAll() {
        return saidaDao.getAll();
    }

}
