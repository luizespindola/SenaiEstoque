/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.EntradaDao;
import br.com.senai.senaiEstoque.entity.Entrada;
import br.com.senai.senaiEstoque.entity.Produto;
import java.util.List;

/**
 *
 * @author User
 */
public class EntradaController {

    private final EntradaDao entradaDao = new EntradaDao();

    public boolean salvar(Entrada entrada) {
        Integer valor = 0;
        if (entrada.getId() != null) {
            valor = entradaDao.getById(entrada.getId()).getQuantidade();
        }
        if (entradaDao.salvar(entrada) == true) {
            Produto produto = entrada.getProduto();
            produto.setQuantidade(produto.getQuantidade() - valor);
            produto.setQuantidade(produto.getQuantidade() + entrada.getQuantidade());
            ProdutoController produtoController = new ProdutoController();
            produtoController.salvar(produto);
            return true;
        } else {
            return false;
        }

    }

    public boolean delete(Entrada entrada) {
        if (entradaDao.delete(entrada) == true) {
            Produto produto = entrada.getProduto();
            produto.setQuantidade(produto.getQuantidade() - entrada.getQuantidade());
            ProdutoController produtoController = new ProdutoController();
            produtoController.salvar(produto);
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
