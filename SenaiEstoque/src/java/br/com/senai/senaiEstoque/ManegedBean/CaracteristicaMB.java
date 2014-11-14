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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 *
 * @author luiz_espindola
 */
@ManagedBean(name = "caracteristicaMB")
@SessionScoped
public class CaracteristicaMB implements Serializable {

    private Caracteristica caracteristica = new Caracteristica();
    private CaracteristicaController caracteristicaController;

    public CaracteristicaMB() {
        caracteristicaController = new CaracteristicaController();
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String salvar() {
        try {
            caracteristicaController.salvar(caracteristica);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível salvar"));
        }
        return "editValorCaracteristica.xhtml";
    }

    public String novo() {
        caracteristica = new Caracteristica();
        return "editCaracteristica.xhtml";
    }

    public String editar() {
        return "editCaracteristica.xhtml";
    }

    public String delete() {
        try {
            caracteristicaController.delete(caracteristica);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover"));
        }

        return "listCaracteristica.xhtml";
    }

    public List<Caracteristica> getAll() {
        caracteristicaController = new CaracteristicaController();
        return caracteristicaController.getAll();
    }

    public String listCaracterisica() {
        return "listCaracteristica.xhtml";
    }

    public String listValorCaracterisica(Caracteristica caracteristica, Integer id) {
        ValorCaracteristicaController valorCaracteristicaController = new ValorCaracteristicaController();
        this.caracteristica = caracteristica;
        caracteristica.setListaValorCaracteristica(valorCaracteristicaController.getAllByIdCaracteristica(id));
        return "listValorCaracteristica.xhtml";
    }

    public void listValorCaracterisica() {
        ValorCaracteristicaController valorCaracteristicaController = new ValorCaracteristicaController();
        caracteristica.setListaValorCaracteristica(valorCaracteristicaController.getAllByIdCaracteristica(this.caracteristica.getId()));
    }

    public List<ValorCaracteristica> populaValorCaracteristica() {
        ValorCaracteristicaController valorCaracteristicaController = new ValorCaracteristicaController();
        return valorCaracteristicaController.getAllByIdCaracteristica(caracteristica.getId());

    }

}
