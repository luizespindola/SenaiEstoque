/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.PermissaoController;
import br.com.senai.senaiEstoque.entity.Permissao;
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
@ManagedBean(name = "permissaoMB")
@SessionScoped
public class PermissaoMB implements Serializable {

    private PermissaoController permissaoController;
    private Permissao permissao = new Permissao();

    public PermissaoMB() {
        permissaoController = new PermissaoController();
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public String salvar() {
        try {
            permissaoController.salvar(permissao);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível salvar"));
        }
        return "listPermissao.xhtml";
    }

    public String novo() {
        permissao = new Permissao();
        return "editPermissao.xhtml";
    }

    public String editar() {
        return "editPermissao.xhtml";
    }

    public String delete() {
        try {
            permissaoController.delete(permissao);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover"));
        }
        return "listPermissao.xhtml";
    }

    public List<Permissao> getAll() {
        permissaoController = new PermissaoController();
        return permissaoController.getAll();
    }

    public String listPermissao() {
        return "listPermissao.xhtml";
    }
}
