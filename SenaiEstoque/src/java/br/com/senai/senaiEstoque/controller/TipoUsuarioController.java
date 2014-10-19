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

    public String insert(TipoUsuario tipoUsuario) {
        if (tipoUsuarioDao.insert(tipoUsuario)!= null) {
            return "Salvo com sucesso";
        } else {
            return "Não foi possível cadastrar novo tipo de usuário";
        }
    }

    public String delete(TipoUsuario tipoUsuario) {
        if (tipoUsuarioDao.delete(tipoUsuario) == true) {
            return "Removido com sucesso";
        } else {
            return "Não foi possível remover tipo de usuário";
        }
    }

    public String update(TipoUsuario tipoUsuario){
        if (tipoUsuarioDao.update(tipoUsuario) == true) {
            return "Atualizado com sucesso";
        } else {
            return "Não foi possível atualizar tipo de usuário";
        }
    }

    public TipoUsuario getById(int id) {
        return tipoUsuarioDao.getById(id);
    }
     
    public List<TipoUsuario> getAll() {
        return tipoUsuarioDao.getAll();
    }
    
}
