package br.com.senai.senaiEstoque.ManegedBean;


import br.com.senai.senaiEstoque.controller.MarcaController;
import br.com.senai.senaiEstoque.entity.Marca;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "marcaConverter")
public class MarcaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Integer id = Integer.parseInt(string);
        MarcaController marcaController=new MarcaController();
        return marcaController.getById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Marca marca=(Marca) o;
        return marca.getId().toString();
    }

}
