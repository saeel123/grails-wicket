import org.apache.wicket.protocol.http.WebApplication;

import grails.util.*
import org.apache.wicket.Application
import org.apache.wicket.spring.injection.annot.SpringComponentInjector
import org.codehaus.groovy.grails.commons.ApplicationHolder
import org.apache.wicket.RuntimeConfigurationType
// import org.apache.wicket.request.mapper.MountedMapper
import org.apache.wicket.request.mapper.parameter.UrlPathPageParametersEncoder

import java.awt.print.Pageable

public class WicketApplication extends WebApplication {
    
    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    Class getHomePage() { HomePage.class }

    /**
     * Configures Grails' application context to be used for @SpringBean injection
     */
    protected void init() {
        super.init()
        //addComponentInstantiationListener(new SpringComponentInjector(this, ApplicationHolder.getApplication().getMainContext(), false));
        getComponentInstantiationListeners().add(new SpringComponentInjector(this)); //replaces above Spring injection in wicket 1.4

        //replaces mountBookmarkablePage() in wicket 1.4
        // mount(new MountedMapper("/home1",HomePage.class, new UrlPathPageParametersEncoder()))
        mountPage("/home2",HomePage.class)
        mountPage("/hometest",HelloWorld.class)
        mountPage("/echoPage",EchoPage.class)
        mountPage("/echo",Echo.class)
        mountPage("/repeat", PageablesPage.class)
        mountPage("/listview", RepeaterTest.class)
        mountPage("/dataviewtest", DataViewTest.class)
        mountPage("/datapagingtest", DataPagingTest.class)
        mountPage("/productdataview", ProductPage.class)





    }

    /**
     * If we're running in Grails development environment use Wicket development environment
     */
    //replaces getConfigurationType() commented out below in wicket 1.4
    public RuntimeConfigurationType getConfigurationType() {
        if(GrailsUtil.isDevelopmentEnv()) {
            return RuntimeConfigurationType.DEVELOPMENT
        }
        return RuntimeConfigurationType.DEPLOYMENT
    }

    /*public String getConfigurationType() {
        if (GrailsUtil.isDevelopmentEnv()) {
            return Application.DEVELOPMENT
        }
        return Application.DEPLOYMENT
    } */


}