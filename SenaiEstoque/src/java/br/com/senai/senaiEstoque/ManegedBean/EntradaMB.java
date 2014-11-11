/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.EntradaController;
import br.com.senai.senaiEstoque.entity.Entrada;
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
@ManagedBean(name = "entradaMB")
@SessionScoped
public class EntradaMB implements Serializable {

    private Entrada entrada = new Entrada();
    EntradaController entradaController;

    public EntradaMB() {
        entradaController = new EntradaController();
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public String salvar() {
        if (entradaController.salvar(entrada) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível cadastrar"));
        }
        return "listEntrada.xhtml";
    }

    public String novo() {
        entrada = new Entrada();
        return "editEntrada.xhtml";
    }

    public String editar() {
        return "editEntrada.xhtml";
    }

    public String delete() {
        if (entradaController.delete(entrada) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover"));
        }
        return "listEntrada.xhtml";
    }

    public List<Entrada> getAll() {
        return entradaController.getAll();
    }

    public String listEntrada() {
        return "listEntrada.xhtml";
    }

    public List<Entrada> getAllByIdProduto(Integer id) {
        return entradaController.getAllByIdProduto(id);
    }

}
