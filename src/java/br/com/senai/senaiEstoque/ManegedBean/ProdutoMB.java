/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.ProdutoController;
import br.com.senai.senaiEstoque.entity.Produto;
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
@ManagedBean(name = "produtoMB")
@SessionScoped
public class ProdutoMB implements Serializable {

    private Produto produto = new Produto();
    private ProdutoController produtoController;

    public ProdutoMB() {
        produtoController = new ProdutoController();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String salvar() {
        try {
            produtoController.salvar(produto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível salvar"));
        }
        return "editProdutoCaracteristica.xhtml";
    }

    public String novo() {
        produto = new Produto();
        return "editProduto.xhtml";
    }

    public String editar() {
        return "editProduto.xhtml";
    }

    public String delete() {
        try {
            produtoController.delete(produto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover"));
        }
        return "listProduto.xhtml";
    }

    public List<Produto> getAll() {
        produtoController = new ProdutoController();
        return produtoController.getAll();
    }

    public String listProduto() {
        return "listProduto.xhtml";
    }

}
