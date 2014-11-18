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
    private FotoController fotoController;

    public FotoMB() {
        fotoController = new FotoController();
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public String salvar() {
        try {
            fotoController.salvar(foto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível salvar"));
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
        try {
            fotoController.delete(foto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover"));
        }
        return "listFoto.xhtml";
    }

    public List<Foto> getAll() {
        fotoController = new FotoController();
        return fotoController.getAll();
    }

    public String listFornecedor() {
        return "listFoto.xhtml";
    }

}
