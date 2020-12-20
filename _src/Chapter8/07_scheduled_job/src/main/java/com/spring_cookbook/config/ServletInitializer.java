package com.spring_cookbook.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.spring_cookbook.batch.BatchConfig;

	public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	    @Override
	    protected Class<?>[] getRootConfigClasses() {
	        return new Class<?>[0];
	    }
	    
	    @Override
	    protected Class<?>[] getServletConfigClasses() {
	        return new Class<?>[]{AppConfig.class, BatchConfig.class};
	    }

	    @Override
	    protected String[] getServletMappings() {
	        return new String[]{"/"};
	    }
	}
