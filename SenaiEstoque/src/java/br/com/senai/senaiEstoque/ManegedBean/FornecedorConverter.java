package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.FornecedorController;
import br.com.senai.senaiEstoque.entity.Fornecedor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "fornecedorConverter")
public class FornecedorConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Integer id = Integer.parseInt(string);
        FornecedorController fornecedorController = new FornecedorController();
        return fornecedorController.getById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Fornecedor fornecedor = (Fornecedor) o;
        return fornecedor.getId().toString();
    }

}
