/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.UsuarioController;
import br.com.senai.senaiEstoque.entity.LoginHolder;
import br.com.senai.senaiEstoque.entity.Usuario;
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
@ManagedBean(name = "usuarioMB")
@SessionScoped
public class UsuarioMB implements Serializable {

    private Usuario usuario = new Usuario();
    private LoginHolder loginHolder = new LoginHolder();

    public LoginHolder getLoginHolder() {
        return loginHolder;
    }

    public void setLoginHolder(LoginHolder loginHolder) {
        this.loginHolder = loginHolder;
    }

    public String insert() {
        UsuarioController usuarioController = new UsuarioController();
        
        if (usuarioController.cadastrar(loginHolder) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastrado com sucesso"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível cadastrar"));
        }
        return "listTipoUsuario.xhtml";
    }

    public String novo() {
        usuario = new Usuario();
        return "editUsuario.xhtml";
    }

    public String editar() {
        return "editUsuario.xhtml";
    }

    public String delete() {
        UsuarioController usuarioController = new UsuarioController();
        if (usuarioController.delete(usuario) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover"));
        }
        return "listUsuario.xhtml";
    }

    public List<Usuario> getAll() {
        UsuarioController usuarioController = new UsuarioController();
        return usuarioController.getAll();
    }

    public String listUsuario() {
        return "listUsuario.xhtml";
    }

}
