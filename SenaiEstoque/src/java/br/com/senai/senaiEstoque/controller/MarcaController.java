/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.MarcaDao;
import br.com.senai.senaiEstoque.entity.Marca;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author User
 */
@ManagedBean
public class MarcaController {
    
    private final MarcaDao marcaDao = new MarcaDao();

    public String insert(Marca marca) {
        if (marcaDao.insert(marca) != null) {
            return "Salvo com sucesso";
        } else {
            return "Não foi possível cadastrar nova marca";
        }
    }

    public String delete(Marca marca) {
        if (marcaDao.delete(marca)== true) {
            return "Removido com sucesso";
        } else {
            return "Não foi possível remover marca";
        }
    }

    public String update(Marca marca) {
        if (marcaDao.update(marca) == true) {
            return "Atualizado com sucesso";
        } else {
            return "Não foi possível atualizar marca";
        }
    }

    public Marca getById(int id) {
        return marcaDao.getById(id);
    }

    public List<Marca> getAll() {
        return marcaDao.getAll();
    }   
    
}
