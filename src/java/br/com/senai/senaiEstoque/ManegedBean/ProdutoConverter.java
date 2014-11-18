package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.ProdutoController;
import br.com.senai.senaiEstoque.entity.Produto;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "produtoConverter")
public class ProdutoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Integer id = Integer.parseInt(string);
        ProdutoController produtoController = new ProdutoController();
        return produtoController.getById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Produto produto = (Produto) o;
        return produto.getId().toString();
    }

}
