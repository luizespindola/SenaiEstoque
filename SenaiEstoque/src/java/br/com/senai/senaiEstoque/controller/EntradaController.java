/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.EntradaDao;
import br.com.senai.senaiEstoque.entity.Entrada;
import java.util.List;

/**
 *
 * @author User
 */
public class EntradaController {
        
    private final EntradaDao entradaDao = new EntradaDao();

    public String insert(Entrada entrada) {
        if (entradaDao.insert(entrada) != null) {
            return "Salvo com sucesso";
        } else {
            return "Não foi possível cadastrar nova entrada";
        }
    }

    public String delete(Entrada entrada) {
        if (entradaDao.delete(entrada) == true) {
            return "Removido com sucesso";
        } else {
            return "Não foi possível remover entrada";
        }
    }

    public String update(Entrada entrada) {
        if (entradaDao.update(entrada) == true) {
            return "Atualizado com sucesso";
        } else {
            return "Não foi possível atualizar entrada";
        }
    }

    public Entrada getById(int id) {
        return entradaDao.getById(id);
    }

    public List<Entrada> getAll() {
        return entradaDao.getAll();
    }
    
}

    
