/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.CorController;
import br.com.senai.senaiEstoque.entity.Cor;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author luiz_espindola
 */
@ManagedBean (name = "corMB")
@SessionScoped
public class CorMB implements Serializable{
    
    private Cor cor=new Cor();

    public Cor getCor(){
        return cor;
    }

    public void setCaracterisitca(Cor cor) {
        this.cor=cor;
    }

    public String salvar() {
        CorController corController = new CorController();
        corController.insert(cor);
        return "listCor.xhtml";
    }

    public String novo() {
        cor = new Cor();
        return "editCor.xhtml";
    }

    public String editar() {
        return "editCor.xhtml";
    }

    public String excluir() {
        CorController corController=new CorController();
        corController.delete(cor);
        return "listCor.xhtml";
    }
    
    public List<Cor> getAll() {
        CorController corController=new CorController();
        return corController.getAll();
    }

    public String listProduto() {
        return "listCaracteristica.xhtml";
    }
    
}
