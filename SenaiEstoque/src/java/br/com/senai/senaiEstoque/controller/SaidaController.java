/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.SaidaDao;
import br.com.senai.senaiEstoque.entity.Saida;
import java.util.List;
/**
 *
 * @author User
 */
public class SaidaController {
    
    private final SaidaDao saidaDao = new SaidaDao();

    public String insert(Saida saida) {
        if (saidaDao.insert(saida)!= null) {
            return "Salvo com sucesso";
        } else {
            return "Não foi possível cadastrar nova saída";
        }
    }

    public String delete(Saida saida) {
        if (saidaDao.delete(saida) == true) {
            return "Removido com sucesso";
        } else {
            return "Não foi possível remover saída";
        }
    }

    public String update(Saida saida){
        if (saidaDao.update(saida) == true) {
            return "Atualizado com sucesso";
        } else {
            return "Não foi possível atualizar saída";
        }
    }

    public Saida getById(int id) {
        return saidaDao.getById(id);
    }
     
    public List<Saida> getAll() {
        return saidaDao.getAll();
    }
    
}
