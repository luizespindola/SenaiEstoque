/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.ValorCaracteristicaDao;
import br.com.senai.senaiEstoque.entity.Caracteristica;
import br.com.senai.senaiEstoque.entity.Produto;
import br.com.senai.senaiEstoque.entity.ValorCaracteristica;
import java.util.List;

/**
 *
 * @author User
 */
public class ValorCaracteristicaController {

    private final ValorCaracteristicaDao valorCaracteristicaDao = new ValorCaracteristicaDao();

    public boolean salvar(ValorCaracteristica valorCaracteristica) {
        if (valorCaracteristicaDao.salvar(valorCaracteristica) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(ValorCaracteristica valorCaracteristica) {
        if (valorCaracteristicaDao.delete(valorCaracteristica) == true) {
            return true;
        } else {
            return false;
        }
    }

    public ValorCaracteristica getById(int id) {
        return valorCaracteristicaDao.getById(id);
    }

    public List<ValorCaracteristica> getAll() {
        return valorCaracteristicaDao.getAll();
    }

    public List<ValorCaracteristica> getAllByIdCaracteristica(Integer id) {
        return valorCaracteristicaDao.getAllByIdCaracteristica(id);
    }

    public List<ValorCaracteristica> getAllByCaracteristica(Caracteristica caracteristica) {
        return valorCaracteristicaDao.getAllByIdCaracteristica(caracteristica);
    }

    public List<ValorCaracteristica> getAllByProduto(Produto produto) {
        return valorCaracteristicaDao.getAllByProduto(produto);
    }

}
