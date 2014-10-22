/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.EntradaController;
import br.com.senai.senaiEstoque.entity.Entrada;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author luiz_espindola
 */
@ManagedBean(name = "entradaMB")
public class EntradaMB implements Serializable{
    
    private Entrada entrada=new Entrada();

    public Entrada getCor(){
        return entrada;
    }

    public void setCaracterisitca(Entrada entrada) {
        this.entrada=entrada;
    }

    public String salvar() {
        EntradaController entradaController = new EntradaController();
        entradaController.insert(entrada);
        return "listEntrada.xhtml";
    }

//    public String novo() {
//        cor = new Cor();
//        return "editCor.xhtml";
//    }
//
//    public String editar() {
//        return "editCor.xhtml";
//    }
//
//    public String excluir() {
//        CorController corController=new CorController();
//        corController.delete(cor);
//        return "listCor.xhtml";
//    }
//    
//    public List<Cor> getAll() {
//        CorController corController=new CorController();
//        return corController.getAll();
//    }
//
//    public String listProduto() {
//        return "listCaracteristica.xhtml";
//    }
//    
//}
}