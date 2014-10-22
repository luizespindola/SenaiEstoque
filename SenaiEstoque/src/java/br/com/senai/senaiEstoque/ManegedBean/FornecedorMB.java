/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.FornecedorController;
import br.com.senai.senaiEstoque.entity.Fornecedor;
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
@ManagedBean(name = "fornecedorMB")
@SessionScoped
public class FornecedorMB implements Serializable{
    
    private Fornecedor fornecedor = new Fornecedor();

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String insert() {
        FornecedorController fornecedorController = new FornecedorController();
        if (fornecedorController.insert(fornecedor)== true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível cadastrar"));
        }
        return "listFornecedor.xhtml";
    }

    public String novo() {
        fornecedor = new Fornecedor();
        return "editFornecedor.xhtml";
    }

    public String editar() {
        return "editFornecedor.xhtml";
    }

    public String delete() {
        FornecedorController fornecedorController = new FornecedorController();
        if (fornecedorController.delete(fornecedor)== true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover"));
        }
        return "listFornecedor.xhtml";
    }

    public List<Fornecedor> getAll() {
        FornecedorController fornecedorController = new FornecedorController();
        return fornecedorController.getAll();
    }

    public String listFornecedor() {
        return "listFornecedor.xhtml";
    }
    
}
