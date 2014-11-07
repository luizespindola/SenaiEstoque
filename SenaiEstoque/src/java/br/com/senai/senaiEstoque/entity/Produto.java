/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author luiz_espindola
 */
@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private Integer codigo;
    private Double precoCusto;
    private Integer quantidade;
    @OneToOne(mappedBy = "produto", cascade = {CascadeType.ALL})
    private Foto foto;
    @OneToOne(mappedBy = "produto", cascade = {CascadeType.ALL})
    private Fornecedor fornecedor;
    @OneToOne(mappedBy = "produto", cascade = {CascadeType.ALL})
    private Marca marca;
    @OneToMany(mappedBy = "produto", cascade = {CascadeType.ALL})
    private List<Saida> listaSaida = new ArrayList<Saida>();
    @OneToMany(mappedBy = "produto", cascade = {CascadeType.ALL})
    private List<Entrada> listaEntradas = new ArrayList<Entrada>();
    @ManyToMany(mappedBy = "listaProduto", cascade = {CascadeType.ALL})
    private List<Caracteristica> listaCaracteristicas = new ArrayList<Caracteristica>();

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

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Saida> getListaSaida() {
        return listaSaida;
    }

    public void setListaSaida(List<Saida> listaSaida) {
        this.listaSaida = listaSaida;
    }

    public List<Entrada> getListaEntradas() {
        return listaEntradas;
    }

    public void setListaEntradas(List<Entrada> listaEntradas) {
        this.listaEntradas = listaEntradas;
    }

    public List<Caracteristica> getListaCaracteristicas() {
        return listaCaracteristicas;
    }

    public void setListaCaracteristicas(List<Caracteristica> listaCaracteristicas) {
        this.listaCaracteristicas = listaCaracteristicas;
    }

}
