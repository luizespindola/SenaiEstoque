/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.MarcaController;
import br.com.senai.senaiEstoque.entity.Marca;
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
@ManagedBean(name = "marcaMB")
@SessionScoped
public class MarcaMB implements Serializable {

    private Marca marca = new Marca();
    private MarcaController marcaController;

    public MarcaMB() {
        marcaController = new MarcaController();
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String salvar() {
        try {
            marcaController.salvar(marca);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível salvar " + e.getMessage()));
        }
        return "listMarca.xhtml";
    }

    public String novo() {
        marca = new Marca();
        return "editMarca.xhtml";
    }

    public String editar() {
        return "editMarca.xhtml";
    }

    public String delete() {
        try {
            marcaController.delete(marca);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover " + e.getMessage()));
        }
        return "listMarca.xhtml";
    }

    public List<Marca> getAll() {
        marcaController = new MarcaController();
        return marcaController.getAll();
    }

    public String listMarca() {
        return "listMarca.xhtml";
    }

}
