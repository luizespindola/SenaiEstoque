/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.CorDao;
import br.com.senai.senaiEstoque.entity.Cor;
import java.util.List;

/**
 *
 * @author User
 */
public class CorController {

    private final CorDao corDao = new CorDao();

    public boolean insert(Cor cor) {
        if (corDao.insert(cor) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Cor cor) {
        if (corDao.delete(cor) == true) {
            return true;
        } else {
            return false;
        }
    }

    public String update(Cor cor) {
        if (corDao.update(cor) == true) {
            return "Atualizado com sucesso";
        } else {
            return "Não foi possível atualizar cor";
        }
    }

    public Cor getById(int id) {
        return corDao.getById(id);
    }

    public List<Cor> getAll() {
        return corDao.getAll();
    }

}
