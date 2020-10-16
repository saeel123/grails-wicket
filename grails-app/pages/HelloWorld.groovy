
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage


public class HelloWorld extends WebPage {
    public HelloWorld() {
        add(new Label("message", "hello World Saeel"));
    }
}