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
import org.dom4j.io.SAXWriter;

/**
 *
 * @author luiz_espindola
 */
@ManagedBean(name = "saidaMB")
@SessionScoped
public class SaidaMB implements Serializable{
    
    private Saida saida = new Saida();

    public Saida getSaida() {
        return saida;
    }

    public void setSaida(Saida saida) {
        this.saida = saida;
    }

    public String insert() {
        SaidaController saidaController = new SaidaController();
        if (saidaController.insert(saida)== true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível cadastrar"));
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
        SaidaController saidaController = new SaidaController();
        if (saidaController.delete(saida)== true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover"));
        }
        return "listProduto.xhtml";
    }

    public List<Saida> getAll() {
        SaidaController saidaController = new SaidaController();
        return saidaController.getAll();
    }

    public String listSaida() {
        return "listSaida.xhtml";
    }
    
}
