import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.model.Model;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class EchoPage extends WebPage {
    private Label label;
    public EchoPage(final PageParameters parameters) {
        label = new Label("message", new Model(""));

        RepeatingView listItems = new RepeatingView("listItems");
        listItems.add(new Label(listItems.newChildId(), "green"));
        listItems.add(new Label(listItems.newChildId(), "blue"));
        listItems.add(new Label(listItems.newChildId(), "red"));
        add(listItems)
    }
}