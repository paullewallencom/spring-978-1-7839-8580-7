package com.spring_cookbook.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionLogger {

	@AfterThrowing(pointcut="execution(* com.spring_cookbook.controllers.*.*(..))", throwing="exception")
	public void logMethodArguments(JoinPoint joinPoint, Exception exception) {
		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		System.out.println("-----" + className + "." + methodName + "() -----");
		System.out.println("exception message:" + exception.getMessage());
	}
	
}
