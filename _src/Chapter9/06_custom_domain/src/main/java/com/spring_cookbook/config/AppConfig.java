package com.spring_cookbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.mobile.device.site.SitePreferenceHandlerInterceptor;
import org.springframework.mobile.device.switcher.SiteSwitcherHandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.spring_cookbook.controllers"})
public class AppConfig extends WebMvcConfigurerAdapter {
	
	@Bean
    public ViewResolver jspViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
	@Bean
	public DeviceResolverHandlerInterceptor deviceResolverHandlerInterceptor() {
	    return new DeviceResolverHandlerInterceptor();
	}
	
	@Bean
	public SitePreferenceHandlerInterceptor sitePreferenceHandlerInterceptor() {
	    return new SitePreferenceHandlerInterceptor();
	}
	
	@Bean
	public SiteSwitcherHandlerInterceptor siteSwitcherHandlerInterceptor() {
	    return SiteSwitcherHandlerInterceptor.standard("mywebsite.com", "mymobilewebsite.com", ".mywebsite.com");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(deviceResolverHandlerInterceptor());
	    registry.addInterceptor(sitePreferenceHandlerInterceptor());
	    registry.addInterceptor(siteSwitcherHandlerInterceptor());
	}
}
