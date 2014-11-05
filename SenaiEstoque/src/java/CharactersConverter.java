
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.xml.stream.events.Characters;

@FacesConverter(value = "charactersConverter")

public class CharactersConverter implements Converter {

    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null) {
            return this.getAttributesFrom(component).get(value);
        }
        return null;
    }

    public String getAsString(FacesContext ctx, UIComponent component, Object value) {

        if (value != null && !"".equals(value)) {

            Characters entity = (Characters) value;

            this.addAttribute(component, entity);

            Long codigo = entity.getId();

            if (codigo != null) {
                return String.valueOf(codigo);
            }
        }

        return (String) value;
    }

    protected void addAttribute(UIComponent component, BaseEntity o) {
        String key = o.getId().toString(); // codigo da empresa como chave neste caso
        this.getAttributesFrom(component).put(key, o);
    }

    protected Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }

}