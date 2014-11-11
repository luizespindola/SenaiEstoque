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
public class FornecedorMB implements Serializable {

    private Fornecedor fornecedor = new Fornecedor();
    private FornecedorController fornecedorController;

    public FornecedorMB() {
        fornecedorController = new FornecedorController();
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String salvar() {
        try {
            fornecedorController.salvar(fornecedor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível salvar"));
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
        try {
            fornecedorController.delete(fornecedor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover"));
        }
        return "listFornecedor.xhtml";
    }

    public List<Fornecedor> getAll() {
        fornecedorController = new FornecedorController();
        return fornecedorController.getAll();
    }

    public String listFornecedor() {
        return "listFornecedor.xhtml";
    }

}
