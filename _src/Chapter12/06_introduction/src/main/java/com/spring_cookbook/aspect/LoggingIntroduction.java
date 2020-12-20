package com.spring_cookbook.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import com.spring_cookbook.util.Logging;
import com.spring_cookbook.util.LoggingConsole;

@Component
@Aspect
public class LoggingIntroduction {

	@DeclareParents(value = "com.spring_cookbook.controllers.*+", defaultImpl = LoggingConsole.class)
	public static Logging mixin;

	@Before("execution(* com.spring_cookbook.controllers.*.*(..)) && this(logging)")
	public void recordUsage(Logging logging) {
		logging.log("this is displayed just before a controller method is executed.");
	}	
}
