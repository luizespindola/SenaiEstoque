/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.UsuarioDao;
import br.com.senai.senaiEstoque.entity.Usuario;
import br.com.senai.senaiEstoque.entity.LoginHolder;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author User
 */
public class UsuarioController {

    private final UsuarioDao usuarioDao = new UsuarioDao();

    public boolean cadastrar(LoginHolder loginHolder) {

        if (loginHolder.getSenha().equals(loginHolder.getResenha())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Campo senha e re-senha são diferentes"));
            return false;
        }

        Usuario usuario = new Usuario();
        if (loginHolder.getId() != 0) {
            usuario.setId(loginHolder.getId());
        }

        usuario.setNome(loginHolder.getNome());
        usuario.setSenha(loginHolder.getSenha());
        usuario.setTipoUsuario(loginHolder.getTipoUsuario());

        if (usuarioDao.insert(usuario) == true) {
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
