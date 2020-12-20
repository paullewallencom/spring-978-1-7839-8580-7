package com.spring_cookbook.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Cleanup {

	@After("execution(* com.spring_cookbook.controllers.*.*(..))")
	public void logMethodArguments(JoinPoint joinPoint) {
		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		System.out.println("-----" + className + "." + methodName + "() -----");
		System.out.println("some cleanup code is executed here");
	}
	
}
