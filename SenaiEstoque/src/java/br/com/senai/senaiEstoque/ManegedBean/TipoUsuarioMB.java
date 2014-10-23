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
public class TipoUsuarioMB implements Serializable{
    
   private TipoUsuario tipoUsuario= new TipoUsuario();

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String insert() {
        TipoUsuarioController tipoUsuarioController = new TipoUsuarioController();
        if (tipoUsuarioController.insert(tipoUsuario)== true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível cadastrar"));
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
        TipoUsuarioController tipoUsuarioController = new TipoUsuarioController();
        if (tipoUsuarioController.delete(tipoUsuario)== true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover"));
        }
        return "listTipoUsuario.xhtml";
    }

    public List<TipoUsuario> getAll() {
        TipoUsuarioController tipoUsuarioController = new TipoUsuarioController();
        return tipoUsuarioController.getAll();
    }

    public String listTipoUsuario() {
        return "listTipoUsuario.xhtml";
    }
    
    
}
