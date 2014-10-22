/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.TipoUsuarioDao;
import br.com.senai.senaiEstoque.entity.TipoUsuario;
import java.util.List;

/**
 *
 * @author User
 */
public class TipoUsuarioController {

    private final TipoUsuarioDao tipoUsuarioDao = new TipoUsuarioDao();

    public boolean insert(TipoUsuario tipoUsuario) {
        if (tipoUsuarioDao.insert(tipoUsuario) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(TipoUsuario tipoUsuario) {
        if (tipoUsuarioDao.delete(tipoUsuario) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean update(TipoUsuario tipoUsuario) {
        if (tipoUsuarioDao.update(tipoUsuario) == true) {
            return true;
        } else {
            return false;
        }
    }

    public TipoUsuario getById(int id) {
        return tipoUsuarioDao.getById(id);
    }

    public List<TipoUsuario> getAll() {
        return tipoUsuarioDao.getAll();
    }

}
