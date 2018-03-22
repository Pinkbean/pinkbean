package com.lsg.pinkbean.bo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan(
	    basePackages = "com.lsg.pinkbean"
	    , useDefaultFilters = false
	    , includeFilters = {
	        @ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION)
	    }
	)
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
    //ViewResolver
    @Bean
    public ContentNegotiatingViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        // JSP ViewResolver
        InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
        jspViewResolver.setViewClass(JstlView.class);
        jspViewResolver.setPrefix("/WEB-INF/");
        jspViewResolver.setSuffix(".jsp");

        // Content Negotiating ViewResolver
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        resolver.setUseNotAcceptableStatusCode(true);

        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
        resolvers.add(jspViewResolver);

        resolver.setViewResolvers(resolvers);
        return resolver;
    }
}
