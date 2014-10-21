/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.FotoDao;
import br.com.senai.senaiEstoque.entity.Foto;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author User
 */
@ManagedBean
public class FotoController {
    
    private final FotoDao fotoDao = new FotoDao();

    public String insert(Foto foto) {
        if (fotoDao.insert(foto) != null) {
            return "Salvo com sucesso";
        } else {
            return "Não foi possível cadastrar nova foto";
        }
    }

    public String delete(Foto foto) {
        if (fotoDao.delete(foto) == true) {
            return "Removido com sucesso";
        } else {
            return "Não foi possível remover foto";
        }
    }

    public String update(Foto foto) {
        if (fotoDao.update(foto) == true) {
            return "Atualizado com sucesso";
        } else {
            return "Não foi possível atualizar foto";
        }
    }

    public Foto getById(int id) {
        return fotoDao.getById(id);
    }

    public List<Foto> getAll() {
        return fotoDao.getAll();
    }    
}
