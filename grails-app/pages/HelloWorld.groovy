
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.link.Link
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.model.PropertyModel


import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.request.mapper.parameter.PageParameters


public class HelloWorld extends WebPage {
    // private Integer counter = 0
    // private Label label

    // public HelloWorld() {
    
    //     add(new Label("message", "hello World Saeel"));
    //      println("counter value"+counter)
    //     add(new AjaxFallbackLink("link") {
    //         // // int counter++
    //         // println("counter value"+counter)

    //         @Override
    //         public void onClick(AjaxRequestTarget target) {
    //             println("counter value"+counter)
    //             counter++

    //             if(target != null) {
    //                 target.addComponent(label)
    //             }
    //         }
    //     });
        
    //     label = new Label("label", new PropertyModel(this, "counter"));
    //     label.setOutputMarkupId(true);
    //     add(label)

        

    // }

    int counter
  Label testlabel
    public HelloWorld(final PageParameters parameters) {
        add(new Link("testlink"){
            @Override                     
            public void onClick() {
              getParent().counter++; 
            }
        });
         add(new AjaxFallbackLink("fallbacklink"){
            @Override                     
            public void onClick(AjaxRequestTarget target) {
              getParent().counter++; 
              if(target!= null){
                target.add(getParent().testlabel)
              }
            }
        });
         testlabel = new Label("testlabel",new PropertyModel(this, "counter"))
         testlabel.setOutputMarkupId(true);
        add(testlabel); 
    }



}