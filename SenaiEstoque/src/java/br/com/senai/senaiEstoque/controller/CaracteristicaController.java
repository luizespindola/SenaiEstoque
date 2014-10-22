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

    public boolean insert(Caracteristica caracteristica) {
        if (caracteristicaDao.insert(caracteristica) == true ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Caracteristica caracteristica) {
        if (caracteristicaDao.delete(caracteristica) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean update(Caracteristica caracteristica) {
        if (caracteristicaDao.update(caracteristica) == true) {
            return true;
        } else {
            return false;
        }
    }

    public Caracteristica getById(int id) {
        return caracteristicaDao.getById(id);
    }

    public List<Caracteristica> getAll() {
        return caracteristicaDao.getAll();
    }

}
