/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.CorController;
import br.com.senai.senaiEstoque.entity.Cor;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author luiz_espindola
 */
@ManagedBean(name = "corMB")
@SessionScoped
public class CorMB implements Serializable {

    private Cor cor = new Cor();

    public Cor getCor() {
        return cor;
    }

    public void setCaracterisitca(Cor cor) {
        this.cor = cor;
    }

    public String insert() {
        CorController corController = new CorController();
        if (corController.insert(cor) ==true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso"));
            return "editCor.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível cadastrar"));
            return "listCor.xhtml";
            
        }
    }

    public String novo() {
        cor = new Cor();
        return "editCor.xhtml";
    }

    public String editar() {
        return "editCor.xhtml";
    }

    public String delete() {
        CorController corController = new CorController();
       if (corController.delete(cor) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
            return "listCor.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover"));
            return "listCor.xhtml";
        }
    }

    public List<Cor> getAll() {
        CorController corController = new CorController();
        return corController.getAll();
    }

    public String listCor() {
        return "listCor.xhtml";
    }

}
