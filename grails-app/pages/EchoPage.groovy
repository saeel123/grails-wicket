
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.model.Model;


public class EchoPage extends WebPage {
    private Label label;
    private TextField field;
    public EchoPage() {
        Form form = new Form("form");
        field = new TextField("field", new Model(""))
        form.add(field)

        // form.add(new Button("button") {
        //     @Override
        //     public void onSubmit() {
        //         String value = (String)field.getModelObject();
        //         label.setModelObject(value);
        //         field.setModelObject("");
        //     }
        // }
        add(form)

        label = new Label("message", new Model(""));
    }
}