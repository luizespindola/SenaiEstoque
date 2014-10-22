/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.CaracteristicaDao;
import br.com.senai.senaiEstoque.entity.Caracteristica;
import java.util.List;

/**
 *
 * @author User
 */
public class CaracteristicaController {

    private final CaracteristicaDao caracteristicaDao = new CaracteristicaDao();

    public String insert(Caracteristica caracteristica) {
        if (caracteristicaDao.insert(caracteristica) != false) {
            return "Salvo com sucesso";
        } else {
            return "Não foi possível cadastrar nova característica";
        }
    }

    public String delete(Caracteristica caracteristica) {
        if (caracteristicaDao.delete(caracteristica) == true) {
            return "Removido com sucesso";
        } else {
            return "Não foi possível remover característica";
        }
    }

    public String update(Caracteristica caracteristica) {
        if (caracteristicaDao.update(caracteristica) == true) {
            return "Atualizado com sucesso";
        } else {
            return "Não foi possível atualizar característica";
        }
    }

    public Caracteristica getById(int id) {
        return caracteristicaDao.getById(id);
    }

    public List<Caracteristica> getAll() {
        return caracteristicaDao.getAll();
    }

}
