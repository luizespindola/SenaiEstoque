/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.senaiEstoque.controller;

import br.com.senai.senaiEstoque.dao.MarcaDao;
import br.com.senai.senaiEstoque.entity.Marca;
import java.util.List;

/**
 *
 * @author User
 */
public class MarcaController {

    private final MarcaDao marcaDao = new MarcaDao();

    /**
     * Insere e edita no banco de dados
     *
     * @param marca objeto Marca
     * @return Boolean
     */
    public boolean salvar(Marca marca) {
        if (marcaDao.salvar(marca) == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Deleta do banco de dados
     *
     * @param marca objeto Marca
     * @return Boolean
     */
    public boolean delete(Marca marca) {
        if (marcaDao.delete(marca) == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Pega por ID
     *
     * @param id Int
     * @return Objeto Marca
     */
    public Marca getById(int id) {
        return marcaDao.getById(id);
    }

    /**
     * Pega todas as marcas
     *
     * @return Lista de Narcas
     */
    public List<Marca> getAll() {
        return marcaDao.getAll();
    }

}
