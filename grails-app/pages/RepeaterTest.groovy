import org.apache.wicket.markup.html.list.ListView
import org.apache.wicket.markup.html.list.ListItem
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.model.PropertyModel

import org.apache.wicket.markup.repeater.data.DataView
import org.apache.wicket.markup.repeater.data.ListDataProvider
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.markup.repeater.Item

public class RepeaterTest extends WebPage {
    private Label label;
    public RepeaterTest(final PageParameters parameters) {
        List<Person> persons = Arrays.asList(new Person("John", "Smith"), new Person("Dan", "Wong"));
        add(new ListView<Person>("persons", persons) {
            @Override
            protected void populateItem(ListItem<Person> item) {
                item.add(new Label("fullName", new PropertyModel(item.getModel(), "fullName")));
            }
        });
    }
}