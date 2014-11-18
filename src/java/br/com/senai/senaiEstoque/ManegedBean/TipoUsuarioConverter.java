package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.TipoUsuarioController;
import br.com.senai.senaiEstoque.entity.TipoUsuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "tipoUsuarioConverter")
public class TipoUsuarioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Integer id = Integer.parseInt(string);
        TipoUsuarioController tipoUsuarioController = new TipoUsuarioController();
        return tipoUsuarioController.getById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        TipoUsuario tipoUsuario = (TipoUsuario) o;
        return tipoUsuario.getId().toString();
    }

}
