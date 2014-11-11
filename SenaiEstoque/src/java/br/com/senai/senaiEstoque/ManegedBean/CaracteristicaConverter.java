package br.com.senai.senaiEstoque.ManegedBean;


import br.com.senai.senaiEstoque.controller.CaracteristicaController;
import br.com.senai.senaiEstoque.controller.FornecedorController;
import br.com.senai.senaiEstoque.entity.Caracteristica;
import br.com.senai.senaiEstoque.entity.Fornecedor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "caracteristicaConverter")
public class CaracteristicaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Integer id = Integer.parseInt(string);
        CaracteristicaController caracteristicaController = new CaracteristicaController();
        return caracteristicaController.getById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Caracteristica caracteristica = (Caracteristica) o;
        return caracteristica.getId().toString();
    }

}
