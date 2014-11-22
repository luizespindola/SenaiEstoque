/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    Integer id;
    private String nome;
    private Integer codigo;
    private Double precoCusto;
    private Integer quantidade;
    @OneToOne(mappedBy = "produto", cascade = {CascadeType.ALL})
    private Foto foto;
    @ManyToOne(cascade = CascadeType.ALL)
    private Fornecedor fornecedor;
    @ManyToOne(cascade = CascadeType.ALL)
    private Marca marca;
    @OneToMany(mappedBy = "produto", cascade = {CascadeType.ALL})
    private List<Saida> listaSaida;
    @OneToMany(mappedBy = "produto", cascade = {CascadeType.ALL})
    private List<Entrada> listaEntrada;
    @ManyToMany
    private List<ValorCaracteristica> listaValorCaracteristicas;
    private ValorCaracteristica valorCaracteristica;

    public Produto() {
        this.listaSaida = new ArrayList<Saida>();
        this.listaEntrada = new ArrayList<Entrada>();
        this.listaValorCaracteristicas = new ArrayList<ValorCaracteristica>();

    }

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

    public List<Entrada> getListaEntrada() {
        return listaEntrada;
    }

    public void setListaEntrada(List<Entrada> listaEntrada) {
        this.listaEntrada = listaEntrada;
    }

    public List<ValorCaracteristica> getListaValorCaracteristicas() {
        return listaValorCaracteristicas;
    }

    public void setListaValorCaracteristicas() {
        this.listaValorCaracteristicas.add(valorCaracteristica);
    }

    public void setListaValorCaracteristicas(ValorCaracteristica valorCaracteristica) {
        this.listaValorCaracteristicas.add(valorCaracteristica);
    }
    
    public void setListaValorCaracteristicas(List<ValorCaracteristica> lista) {
        this.listaValorCaracteristicas=lista;
    }

    public ValorCaracteristica getValorCaracteristica() {
        return valorCaracteristica;
    }

    public void setValorCaracteristica(ValorCaracteristica valorCaracteristica) {
        this.valorCaracteristica = valorCaracteristica;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
