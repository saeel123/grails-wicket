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

public class ProductPage extends WebPage {
    private Label label;
    public ProductPage(final PageParameters parameters) {
            List<Product> products =  Arrays.asList(new Product("Samsung Mobile", "M20", "SM20"), new Product("Samsung Mobile", "M21", "SM21"),
                    new Product("Samsung Mobile", "M21s", "SM21s"));
            ListDataProvider<Product> listDataProvider = new ListDataProvider<Product>(products);
            DataView<Product> dataView = new DataView<Product>("rows", listDataProvider) {

            @Override
            protected void populateItem(Item<Product> item) {
                Product product = item.getModelObject();
                RepeatingView repeatingView = new RepeatingView("dataRow");

                repeatingView.add(new Label(repeatingView.newChildId(), product.getProductName()));
                repeatingView.add(new Label(repeatingView.newChildId(), product.getVarientName()));
                repeatingView.add(new Label(repeatingView.newChildId(), product.getVarientSku()));
                item.add(repeatingView);
            }
        };
        add(dataView);
    }
}