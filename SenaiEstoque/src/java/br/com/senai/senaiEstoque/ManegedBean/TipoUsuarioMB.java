/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.TipoUsuarioController;
import br.com.senai.senaiEstoque.entity.TipoUsuario;
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
@ManagedBean(name = "tipoUsuarioMB")
@SessionScoped
public class TipoUsuarioMB implements Serializable {

    private TipoUsuarioController tipoUsuarioController;
    private TipoUsuario tipoUsuario = new TipoUsuario();

    public TipoUsuarioMB() {
        tipoUsuarioController = new TipoUsuarioController();
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String insert() {

        try {
            tipoUsuarioController.salvar(tipoUsuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível salvar"));
        }
        return "listTipoUsuario.xhtml";
    }

    public String novo() {
        tipoUsuario = new TipoUsuario();
        return "editTipoUsuario.xhtml";
    }

    public String editar() {
        return "editTipoUsuario.xhtml";
    }

    public String delete() {
        try {
            tipoUsuarioController.delete(tipoUsuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
        } catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover"));
        }
        return "listTipoUsuario.xhtml";
    }

    public List<TipoUsuario> getAll() {
        tipoUsuarioController = new TipoUsuarioController();
        return tipoUsuarioController.getAll();
    }

    public String listTipoUsuario() {
        return "listTipoUsuario.xhtml";
    }

}
