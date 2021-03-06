package br.com.senai.senaiEstoque.ManegedBean;

import br.com.senai.senaiEstoque.controller.ValorCaracteristicaController;
import br.com.senai.senaiEstoque.entity.ValorCaracteristica;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "valorCaracteristicaConverter")
public class ValorCaracteristicaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        if (string.equalsIgnoreCase("Nenhum") || string.equalsIgnoreCase("Nenhuma")) {
            return new ValorCaracteristica();
        }

        Integer id = Integer.parseInt(string);
        ValorCaracteristicaController valorCaracteristicaController = new ValorCaracteristicaController();
        return valorCaracteristicaController.getById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {

        if (o instanceof String) {
            return (String) o;
        }

        ValorCaracteristica valorCaracteristica = (ValorCaracteristica) o;
        return valorCaracteristica.getId().toString();
    }

}
