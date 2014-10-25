/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.PermissaoDao;
import br.com.senai.senaiEstoque.entity.Permissao;
import java.util.List;

/**
 *
 * @author User
 */
public class PermissaoController {
    
    private final PermissaoDao permissaoDao=new PermissaoDao();

    public boolean insert(Permissao permissao) {
        if (permissaoDao.insert(permissao) == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Permissao permissao) {
        if (permissaoDao.delete(permissao)== true) {
            return true;
        } else {
            return false;
        }
    }

    public Permissao getById(int id) {
        return permissaoDao.getById(id);
    }

    public List<Permissao> getAll() {
        return permissaoDao.getAll();
    } 
    
}
