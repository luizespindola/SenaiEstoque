/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.CaracteristicaController;
import br.com.senai.senaiEstoque.entity.Caracteristica;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author luiz_espindola
 */
@ManagedBean(name = "caracteristicaMB")
@SessionScoped
public class CaracteristicaMB implements Serializable {

    private Caracteristica caracteristica = new Caracteristica();

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracterisitca(Caracteristica caracteristica) {
        this.caracteristica=caracteristica;
    }

    public String salvar() {
        CaracteristicaController caracteristicaController = new CaracteristicaController();
        caracteristicaController.insert(caracteristica);
        return "listCaracteristica.xhtml";
    }

    public String novo() {
        caracteristica = new Caracteristica();
        return "editCaracteristica.xhtml";
    }

    public String editar() {
        return "editCaracteristica.xhtml";
    }

    public String excluir() {
        CaracteristicaController caracteristicaController=new CaracteristicaController();
        caracteristicaController.delete(caracteristica);
        return "listCaracteristica.xhtml";
    }
    
    public List<Caracteristica> getAll() {
        CaracteristicaController caracteristicaController=new CaracteristicaController();
        return caracteristicaController.getAll();
    }

    public String listProduto() {
        return "listCaracteristica.xhtml";
    }

}

