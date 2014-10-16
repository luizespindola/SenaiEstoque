/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Caracteristica {
    
    private Integer id;
    private String nome;
    private ValorCaracteristica valorCaracteristica;
    private List<Produto> listaProduto=new ArrayList<Produto>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ValorCaracteristica getValorCaracteristica() {
        return valorCaracteristica;
    }

    public void setValorCaracteristica(ValorCaracteristica valorCaracteristica) {
        this.valorCaracteristica = valorCaracteristica;
    }

    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }
    
    
}
