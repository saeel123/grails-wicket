import java.util.Arrays;

import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import shopify.api.ShopifyClient

import org.apache.wicket.markup.html.WebPage



/**
 * Shows an ajaxian paging navigator in action.
 *
 * @author Martijn Dashorst
 */
public class PageablesPage extends WebPage
{
    def names = ["Doe, John", "Presley, Elvis", "Presly, Priscilla", "John, Elton", "Jackson, Michael", "Bush, George", "Baker, George"];


    public PageablesPage()
    {

        ShopifyClient  shopifyClient = new ShopifyClient(
                '7b1f86c92278488d1c750fcfc3472714',
                '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',
                'goa-fish-market-test.myshopify.com',
                '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'
        )
        HashMap<String,String> queryParams = new HashMap<String, String>();
        // queryParams.put("page","1")
        // queryParams.put("limit","250")
        String responseText = shopifyClient.getProductService().getProducts(queryParams)
        add(new Label("message", responseText));


        WebMarkupContainer datacontainer = new WebMarkupContainer("data");
        datacontainer.setOutputMarkupId(true);
        add(datacontainer);

        PageableListView listview = new PageableListView("rows", names, 3) {
                    @Override
                    protected void populateItem(ListItem item)
                    {
                        item.add(new Label("name", item.getDefaultModelObjectAsString()));
                    }
                };

        datacontainer.add(listview);
        datacontainer.add(new AjaxPagingNavigator("navigator", listview));
        datacontainer.setVersioned(false);
    }
}