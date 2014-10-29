/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.CaracteristicaController;
import br.com.senai.senaiEstoque.controller.ValorCaracteristicaController;
import br.com.senai.senaiEstoque.entity.Caracteristica;
import br.com.senai.senaiEstoque.entity.ValorCaracteristica;
import java.io.Serializable;
import java.util.List;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Session;

/**
 *
 * @author luiz_espindola
 */
@ManagedBean(name = "valorCaracteristicaMB")
@SessionScoped
public class ValorCaracteristicaMB implements Serializable {

    private ValorCaracteristica valorCaracteristica = new ValorCaracteristica();
    private Caracteristica caracteristica = new Caracteristica();

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    public ValorCaracteristica getValorCaracteristica() {
        return valorCaracteristica;
    }

    public void setValorCaracteristica(ValorCaracteristica valorCaracteristica) {
        this.valorCaracteristica = valorCaracteristica;
    }

    public String insert() {

        ValorCaracteristicaController valorCaracteristicaController = new ValorCaracteristicaController();
        CaracteristicaController caracteristicaControler = new CaracteristicaController();

        valorCaracteristica.setCaracteristica(caracteristica);

        if (valorCaracteristicaController.insert(valorCaracteristica) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível cadastrar o valor da categoria"));
        }

        return "listCaracteristica.xhtml";
    }

    public String novo() {
        valorCaracteristica = new ValorCaracteristica();
        return "editValorCaracteristica.xhtml";
    }

    public String editar() {
        return "editValorCaracteristica.xhtml";
    }

    public String delete() {
        ValorCaracteristicaController valorCaracteristicaController = new ValorCaracteristicaController();
        if (valorCaracteristicaController.delete(valorCaracteristica) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover"));
        }
        return "listValorCaracteristica.xhtml";
    }

    public List<ValorCaracteristica> getAll() {
        ValorCaracteristicaController valorCaracteristicaController = new ValorCaracteristicaController();
        return valorCaracteristicaController.getAll();
    }

    public String listValorCaracteristica() {
        return "listValorCaracteristica.xhtml";
    }

}
