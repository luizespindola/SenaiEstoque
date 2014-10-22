/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.ValorCaracteristicaDao;
import br.com.senai.senaiEstoque.entity.ValorCaracteristica;
import java.util.List;
/**
 *
 * @author User
 */
public class ValorCaracteristicaController {
    
    private final ValorCaracteristicaDao valorCaracteristicaDao = new ValorCaracteristicaDao();

    public String insert(ValorCaracteristica valorCaracteristica){
        if (valorCaracteristicaDao.insert(valorCaracteristica)!= null) {
            return "Salvo com sucesso";
        } else {
            return "Não foi possível cadastrar novo valor de caracteristica";
        }
    }

    public String delete(ValorCaracteristica valorCaracteristica) {
        if (valorCaracteristicaDao.delete(valorCaracteristica) == true) {
            return "Removido com sucesso";
        } else {
            return "Não foi possível remover valor de caracteristica";
        }
    }

    public String update(ValorCaracteristica valorCaracteristica){
        if (valorCaracteristicaDao.update(valorCaracteristica) == true) {
            return "Atualizado com sucesso";
        } else {
            return "Não foi possível atualizar valor de caracteristica";
        }
    }

    public ValorCaracteristica getById(int id) {
        return valorCaracteristicaDao.getById(id);
    }
     
    public List<ValorCaracteristica> getAll() {
        return valorCaracteristicaDao.getAll();
    }
    
}
