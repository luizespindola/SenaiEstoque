/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.CaracteristicaController;
import br.com.senai.senaiEstoque.controller.ValorCaracteristicaController;
import br.com.senai.senaiEstoque.entity.Caracteristica;
import br.com.senai.senaiEstoque.entity.Produto;
import br.com.senai.senaiEstoque.entity.ValorCaracteristica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author luiz_espindola
 */
@ManagedBean(name = "valorCaracteristicaMB")
@SessionScoped
public class ValorCaracteristicaMB implements Serializable {

    private ValorCaracteristicaController valorCaracteristicaController;
    private ValorCaracteristica valorCaracteristica;
    private List<Caracteristica> caracteristicas;
    private CaracteristicaController caracteristicaController = new CaracteristicaController();
    private Caracteristica caracteristica;
    private List<ValorCaracteristica> valorCaracteristicas;

    public ValorCaracteristicaMB() {
        valorCaracteristicaController = new ValorCaracteristicaController();
        valorCaracteristica = new ValorCaracteristica();
    }

    public void init() {
        caracteristicas = caracteristicaController.getAll();
    }

    public List<ValorCaracteristica> getValorCaracteristicas() {
        return valorCaracteristicas;
    }

    public void setValorCaracteristicas(List<ValorCaracteristica> valorCaracteristicas) {
        this.valorCaracteristicas = valorCaracteristicas;
    }

    public ValorCaracteristica getValorCaracteristica() {
        return valorCaracteristica;
    }

    public void setValorCaracteristica(ValorCaracteristica valorCaracteristica) {
        this.valorCaracteristica = valorCaracteristica;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String salvar() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory factory = facesContext.getApplication().getExpressionFactory();
        CaracteristicaMB caracteristicaMB = (CaracteristicaMB) factory.createValueExpression(elContext, "#{caracteristicaMB}", Object.class).getValue(elContext);

        valorCaracteristica.setCaracteristica(caracteristicaMB.getCaracteristica());

        try {
            valorCaracteristicaController.salvar(valorCaracteristica);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível salvar o valor da caracteristica"));
        }
        valorCaracteristica = new ValorCaracteristica();

        return "listValorCaracteristica.xhtml";
    }

    public String novo(CaracteristicaMB caracteristicaMB) {
        valorCaracteristica = new ValorCaracteristica();
        return "editValorCaracteristica.xhtml";
    }

    public String editar() {
        return "editValorCaracteristica.xhtml";
    }

    public String delete() {
        try {
            valorCaracteristicaController.delete(valorCaracteristica);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Removido com sucesso"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possível remover"));
        }
        return "listValorCaracteristica.xhtml";
    }

    public List<ValorCaracteristica> getAll() {
        valorCaracteristicaController = new ValorCaracteristicaController();
        return valorCaracteristicaController.getAll();
    }

    public String listValorCaracteristica() {
        return "listValorCaracteristica.xhtml";
    }

    public List<ValorCaracteristica> getAllByIdCaracteristica(Integer id) {
        valorCaracteristicaController = new ValorCaracteristicaController();
        return valorCaracteristicaController.getAllByIdCaracteristica(id);
    }

    public List<ValorCaracteristica> getAllByProduto(Produto produto) {
        valorCaracteristicaController = new ValorCaracteristicaController();
        return valorCaracteristicaController.getAllByProduto(produto);
    }

    /*
     * Action handlers
     */
    public void changeValor() {
        if (caracteristica != null && !caracteristica.equals("")) {
            valorCaracteristicas = valorCaracteristicaController.getAllByCaracteristica(caracteristica);
        } else {
            valorCaracteristicas = new ArrayList<>();
        }
    }

}
