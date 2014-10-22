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
import javax.faces.context.FacesContext;

/**
 *
 * @author luiz_espindola
 */
@ManagedBean(name = "entradaMB")
public class EntradaMB implements Serializable {

    private Entrada entrada = new Entrada();

    public Entrada getCor() {
        return entrada;
    }

    public void setCaracterisitca(Entrada entrada) {
        this.entrada = entrada;
    }

    public String insert() {
        EntradaController entradaController = new EntradaController();
        if (entradaController.insert(entrada) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso"));
            return "listEntrada.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível cadastrar"));
            return "listEntrada.xhtml";
        }
    }

    public String novo() {
        entrada = new Entrada();
        return "editEntrada.xhtml";
    }

    public String editar() {
        return "editEntrada.xhtml";
    }

    public String excluir() {
        EntradaController entradaController = new EntradaController();
        if (entradaController.delete(entrada) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
            return "listEntrada.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover"));
            return "listEntrada.xhtml";
        }

    }

    public List<Entrada> getAll() {
        EntradaController entradaController = new EntradaController();
        return entradaController.getAll();
    }

    public String listEntrada() {
        return "listEntrada.xhtml";
    }

}
