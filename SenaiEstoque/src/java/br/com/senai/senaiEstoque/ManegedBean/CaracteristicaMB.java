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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author luiz_espindola
 */
@ManagedBean(name = "caracteristicaMB")
@SessionScoped
public class CaracteristicaMB implements Serializable {

    private Caracteristica caracteristica = new Caracteristica();

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracterisitca(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String insert() {
        CaracteristicaController caracteristicaController = new CaracteristicaController();

        if (caracteristicaController.insert(caracteristica) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível cadastrar"));
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
        CaracteristicaController caracteristicaController = new CaracteristicaController();

        if (caracteristicaController.delete(caracteristica) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover"));
        }

        return "listCaracteristica.xhtml";
    }

    public List<Caracteristica> getAll() {
        CaracteristicaController caracteristicaController = new CaracteristicaController();
        return caracteristicaController.getAll();
    }

    public String listCaracterisica() {
        return "listCaracteristica.xhtml";
    }

}
