/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.FotoController;
import br.com.senai.senaiEstoque.entity.Foto;
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
@ManagedBean(name = "fotoMB")
@SessionScoped
public class FotoMB implements Serializable {

    private Foto foto = new Foto();

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public String insert() {
        FotoController fotoController = new FotoController();
        if (fotoController.insert(foto) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível cadastrar"));
        }
        return "listFoto.xhtml";
    }

    public String novo() {
        foto = new Foto();
        return "editFoto.xhtml";
    }

    public String editar() {
        return "editFoto.xhtml";
    }

    public String delete() {
        FotoController fotoController = new FotoController();
        if (fotoController.delete(foto) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover"));
        }
        return "listFoto.xhtml";
    }

    public List<Foto> getAll() {
        FotoController fotoController = new FotoController();
        return fotoController.getAll();
    }

    public String listFornecedor() {
        return "listFoto.xhtml";
    }

}
