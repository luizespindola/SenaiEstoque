/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.CorDao;
import br.com.senai.senaiEstoque.entity.Cor;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author User
 */
@ManagedBean
public class CorController {

    private final CorDao corDao = new CorDao();
    private Cor cor = new Cor();

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public String insert() {  
        if (corDao.insert(cor) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso"));
            return "listCor.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível cadastrar"));
            return "listCor.xhtml";
        }
    }

    public String delete(Cor cor) {
        
        if (corDao.delete(cor) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
            return "listDeCor.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover cor"));
            return "listCor.xhtml";
        }
        
    }

    public String update(Cor cor) {
        if (corDao.update(cor) == true) {
            return "Atualizado com sucesso";
        } else {
            return "Não foi possível atualizar cor";
        }
    }

    public Cor getById(int id) {
        return corDao.getById(id);
    }

    public List<Cor> getAll() {
        return corDao.getAll();
    }

}
