package books.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext rootConfig = new AnnotationConfigWebApplicationContext();
        rootConfig.register(RootConfig.class);

        servletContext.addListener(new ContextLoaderListener(rootConfig));

        AnnotationConfigWebApplicationContext webConfig = new AnnotationConfigWebApplicationContext();
        rootConfig.register(WebConfig.class);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webConfig));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}