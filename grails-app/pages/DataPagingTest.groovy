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
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator

public class DataPagingTest extends WebPage {

    public DataPagingTest(final PageParameters parameters) {
        super(parameters);
        //method loadCountriesFromCsv is defined elsewhere in the class.
        //It reads countries data from a csv file and returns each row as an array of Strings.
        List<String[]> countries = ["ss, sss, sss, ssss, ssssss", "ss, sss, sss, ssss, ssssss" ]
        ListDataProvider<String[]> listDataProvider = new ListDataProvider<String[]>(countries);
        DataView<String[]> dataView = new DataView<String[]>("rows", listDataProvider) {
            @Override
            protected void populateItem(Item<String[]> item) {
                String[] countriesArr = item.getModelObject();
                RepeatingView repeatingView = new RepeatingView("dataRow");

                for (int i = 0; i < countriesArr.length; i++){
                    repeatingView.add(new Label(repeatingView.newChildId(), countriesArr[i]));
                }
                item.add(repeatingView);
            }
        };

        dataView.setItemsPerPage(1);

        add(dataView);
        add(new PagingNavigator("pagingNavigator", dataView));
    }

}