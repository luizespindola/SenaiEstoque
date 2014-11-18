/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.SaidaController;
import br.com.senai.senaiEstoque.entity.Saida;
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
@ManagedBean(name = "saidaMB")
@SessionScoped
public class SaidaMB implements Serializable {

    private SaidaController saidaController;
    private Saida saida = new Saida();

    public SaidaMB() {
        saidaController = new SaidaController();
    }

    public Saida getSaida() {
        return saida;
    }

    public void setSaida(Saida saida) {
        this.saida = saida;
    }

    public String salvar() {
        try {
            saidaController.salvar(saida);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível salvar"));
        }
        return "listSaida.xhtml";
    }

    public String novo() {
        saida = new Saida();
        return "editSaida.xhtml";
    }

    public String editar() {
        return "editSaida.xhtml";
    }

    public String delete() {
        try {
            saidaController.delete(saida);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover"));
        }
        return "listSaida.xhtml";
    }

    public List<Saida> getAll() {
        saidaController = new SaidaController();
        return saidaController.getAll();
    }

    public String listSaida() {
        return "listSaida.xhtml";
    }

}
