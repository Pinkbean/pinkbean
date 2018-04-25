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
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.lsg.pinkbean.bo.resolvers.JsonViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(
	    basePackages = "com.lsg.pinkbean.bo"
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
    
    // ViewResolver
    @Bean
    public ContentNegotiatingViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        // JSP ViewResolver
        InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
        jspViewResolver.setViewClass(JstlView.class);
        jspViewResolver.setPrefix("/WEB-INF/jsp/");
        jspViewResolver.setSuffix(".jsp");
        
        // Tiles ViewResolver
        // 여기서 setPrefix를 설정하면 당연히 tiles.xml에서 사용하는 경로 또한 영향을 받는다. 아무것도 안 주는 쪽이 편리할듯.
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setViewClass(TilesView.class);
        tilesViewResolver.setOrder(1); // 제일 먼저 받아야하니까 order을 1로 주어야 한다.
        
        // jsonViewResolver
        JsonViewResolver jsonViewResolver = new JsonViewResolver();

        // Content Negotiating ViewResolver
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        resolver.setUseNotAcceptableStatusCode(true);

        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
        resolvers.add(jspViewResolver);
        resolvers.add(tilesViewResolver);
        resolvers.add(jsonViewResolver);
        
        resolver.setViewResolvers(resolvers);
        return resolver;
    }
    
    // Tiles
    // 참고사이트: http://websystique.com/springmvc/spring-4-mvc-apache-tiles-3-annotation-based-example/
    @Bean
    public TilesConfigurer tilesConfigurer() {
    	TilesConfigurer tilesConfigurer = new TilesConfigurer();
    	tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/views/tiles/tiles.xml"});
    	tilesConfigurer.setCheckRefresh(true);
    	return tilesConfigurer;
    }
    
    
}
