package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.PermissaoController;
import br.com.senai.senaiEstoque.entity.Permissao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "permissaoConverter")
public class PermissaoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Integer id = Integer.parseInt(string);
        PermissaoController permissaoController = new PermissaoController();
        return permissaoController.getById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Permissao permissao = (Permissao) o;
        return permissao.getId().toString();
    }

}
