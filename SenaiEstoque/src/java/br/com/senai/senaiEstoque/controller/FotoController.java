/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.FotoDao;
import br.com.senai.senaiEstoque.entity.Foto;
import java.util.List;

/**
 *
 * @author User
 */
public class FotoController {
    
    private final FotoDao fotoDao = new FotoDao();

    public boolean insert(Foto foto) {
        if (fotoDao.insert(foto) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Foto foto) {
        if (fotoDao.delete(foto) == true) {
            return true;
        } else {
            return false;
        }
    }

    public Foto getById(int id) {
        return fotoDao.getById(id);
    }

    public List<Foto> getAll() {
        return fotoDao.getAll();
    }    
}
