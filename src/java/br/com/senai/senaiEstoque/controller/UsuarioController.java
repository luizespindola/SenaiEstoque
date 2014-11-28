/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.UsuarioDao;
import br.com.senai.senaiEstoque.entity.Usuario;
import java.util.List;

/**
 *
 * @author User
 */
public class UsuarioController {

    private final UsuarioDao usuarioDao = new UsuarioDao();

    public boolean salvar(Usuario usuario) {

        if (usuarioDao.salvar(usuario) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Usuario usuario) {
        if (usuarioDao.delete(usuario) == true) {
            return true;
        } else {
            return false;
        }
    }

    public Usuario getById(int id) {
        return usuarioDao.getById(id);
    }

    public List<Usuario> getAll() {
        return usuarioDao.getAll();
    }
}
