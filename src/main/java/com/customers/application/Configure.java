package com.customers.application;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.customers.configuration.AppConfiguration;
public class Configure implements WebApplicationInitializer{
    public void onStartup(ServletContext ctx) throws ServletException {
        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        webCtx.register(AppConfiguration.class);
        webCtx.setServletContext(ctx);
        ServletRegistration.Dynamic servlet = ctx.addServlet("dispatcher", new DispatcherServlet(webCtx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}