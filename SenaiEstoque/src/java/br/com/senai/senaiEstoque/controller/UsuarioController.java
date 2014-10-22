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

    public String insert(Usuario usuario) {
        if (usuarioDao.insert(usuario)!= null) {
            return "Salvo com sucesso";
        } else {
            return "Não foi possível cadastrar novo usuário";
        }
    }

    public String delete(Usuario usuario) {
        if (usuarioDao.delete(usuario) == true) {
            return "Removido com sucesso";
        } else {
            return "Não foi possível remover usuário";
        }
    }

    public String update(Usuario usuario){
        if (usuarioDao.update(usuario) == true) {
            return "Atualizado com sucesso";
        } else {
            return "Não foi possível atualizar usuário";
        }
    }

    public Usuario getById(int id) {
        return usuarioDao.getById(id);
    }
     
    public List<Usuario> getAll() {
        return usuarioDao.getAll();
    }
}
