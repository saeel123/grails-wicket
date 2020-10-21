
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.request.mapper.parameter.PageParameters;
import shopify.api.ShopifyClient




/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	// TODO Add any page properties or variables here

    /**
	 * Constructor that is invoked when page is invoked without a session.
	 *
	 * @param parameters
	 *            Page parameters
	 */
    public HomePage(final PageParameters parameters) {

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


        // Add the simplest type of label
        add(new Label("message", responseText));

        // TODO Add your page's components here


	

    }
}
