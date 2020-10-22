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

public class DataViewTest extends WebPage {
    private Label label;
    public DataViewTest(final PageParameters parameters) {
//        List<Person> persons = Arrays.asList(new Person("John", "Smith"), new Person("Dan", "Wong"));
//        add(new ListView<Person>("persons", persons) {
//            @Override
//            protected void populateItem(ListItem<Person> item) {
//                item.add(new Label("fullName", new PropertyModel(item.getModel(), "fullName")));
//            }
//        });

        //method loadPersons is defined elsewhere
        List<Person> persons =  Arrays.asList(new Person("John", "Smith", "sd", "sds"), new Person("Dan", "Wong", "sd", "sds"));;
        ListDataProvider<Person> listDataProvider = new ListDataProvider<Person>(persons);
        DataView<Person> dataView = new DataView<Person>("rows", listDataProvider) {

            @Override
            protected void populateItem(Item<Person> item) {
                Person person = item.getModelObject();
                RepeatingView repeatingView = new RepeatingView("dataRow");

                repeatingView.add(new Label(repeatingView.newChildId(), person.getName()));
                repeatingView.add(new Label(repeatingView.newChildId(), person.getSurname()));
                repeatingView.add(new Label(repeatingView.newChildId(), person.getAddress()));
                repeatingView.add(new Label(repeatingView.newChildId(), person.getEmail()));
                item.add(repeatingView);
            }
        };
        add(dataView);

    }
}