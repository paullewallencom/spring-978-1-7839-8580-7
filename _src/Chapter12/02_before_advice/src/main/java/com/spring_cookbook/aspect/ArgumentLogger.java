package com.spring_cookbook.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ArgumentLogger {

	@Before("execution(* com.spring_cookbook.controllers.*.*(..))")
	public void logMethodArguments(JoinPoint joinPoint) {
		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		System.out.println("-----" + className + "." + methodName + "() -----");
		
		Object[] arguments = joinPoint.getArgs();
		for (int i = 0; i < arguments.length; i++) {
			System.out.println(arguments[i]);
		}
	}

}
