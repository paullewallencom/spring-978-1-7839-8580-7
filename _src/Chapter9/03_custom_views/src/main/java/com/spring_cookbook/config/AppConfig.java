package com.spring_cookbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.mobile.device.site.SitePreferenceHandlerInterceptor;
import org.springframework.mobile.device.switcher.SiteSwitcherHandlerInterceptor;
import org.springframework.mobile.device.view.LiteDeviceDelegatingViewResolver;
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
	
//	@Bean
//    public ViewResolver jspViewResolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setViewClass(JstlView.class);
//        resolver.setPrefix("/WEB-INF/jsp/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
	
	@Bean
	public DeviceResolverHandlerInterceptor deviceResolverHandlerInterceptor() {
	    return new DeviceResolverHandlerInterceptor();
	}
	
	@Bean
	public SitePreferenceHandlerInterceptor sitePreferenceHandlerInterceptor() {
	    return new SitePreferenceHandlerInterceptor();
	}

//	@Bean
//	public SiteSwitcherHandlerInterceptor siteSwitcherHandlerInterceptor() {
//	    return SiteSwitcherHandlerInterceptor.mDot("mysite.com");
//	}

//	@Bean
//	public SiteSwitcherHandlerInterceptor siteSwitcherHandlerInterceptor() {
//	    return SiteSwitcherHandlerInterceptor.standard("mysite.com", 
//	        "mobile.mysite.com", "tablet.mysite.com", "mysite.com");
//	}
	
	@Bean
	public SiteSwitcherHandlerInterceptor siteSwitcherHandlerInterceptor() {
	    return SiteSwitcherHandlerInterceptor.urlPath("/m", "spring_webapp");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(deviceResolverHandlerInterceptor());
	    registry.addInterceptor(sitePreferenceHandlerInterceptor());
	    registry.addInterceptor(siteSwitcherHandlerInterceptor());
	}
	
	@Bean
	public LiteDeviceDelegatingViewResolver liteDeviceAwareViewResolver() {
	    InternalResourceViewResolver delegate = new InternalResourceViewResolver();
	    delegate.setPrefix("/WEB-INF/jsp/");
	    delegate.setSuffix(".jsp");
	    LiteDeviceDelegatingViewResolver resolver = new LiteDeviceDelegatingViewResolver(delegate);
	    resolver.setMobilePrefix("mobile/");
	    //resolver.setTabletPrefix("tablet/");
	    resolver.setEnableFallback(true);
	    return resolver;
	}
}
