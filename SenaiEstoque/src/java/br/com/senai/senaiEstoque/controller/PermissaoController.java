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

    public String insert(Permissao permissao) {
        if (permissaoDao.insert(permissao) != null) {
            return "Salvo com sucesso";
        } else {
            return "Não foi possível cadastrar nova permissao";
        }
    }

    public String delete(Permissao permissao) {
        if (permissaoDao.delete(permissao)== true) {
            return "Removido com sucesso";
        } else {
            return "Não foi possível remover permissao";
        }
    }

    public String update(Permissao permissao) {
        if (permissaoDao.update(permissao) == true) {
            return "Atualizado com sucesso";
        } else {
            return "Não foi possível atualizar permissao";
        }
    }

    public Permissao getById(int id) {
        return permissaoDao.getById(id);
    }

    public List<Permissao> getAll() {
        return permissaoDao.getAll();
    } 
    
}
