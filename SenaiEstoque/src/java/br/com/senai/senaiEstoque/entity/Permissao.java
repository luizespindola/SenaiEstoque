/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.entity;

/**
 *
 * @author User
 */
public class Permissao {
    
    private Integer id;
    private Boolean visualizar;
    private Boolean editar;
    private Boolean editarPermissao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getVisualizar() {
        return visualizar;
    }

    public void setVisualizar(Boolean visualizar) {
        this.visualizar = visualizar;
    }

    public Boolean getEditar() {
        return editar;
    }

    public void setEditar(Boolean editar) {
        this.editar = editar;
    }

    public Boolean getEditarPermissao() {
        return editarPermissao;
    }

    public void setEditarPermissao(Boolean editarPermissao) {
        this.editarPermissao = editarPermissao;
    }
    
    
    
}
