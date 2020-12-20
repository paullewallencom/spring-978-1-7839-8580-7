package com.spring_cookbook.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodReturnLogger {

	@AfterReturning(pointcut="execution(* com.spring_cookbook.controllers.*.*(..))", returning="returnValue")
	public void logMethodArguments(JoinPoint joinPoint, Object returnValue) {
		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		System.out.println("-----" + className + "." + methodName + "() -----");
		System.out.println("returnValue=" + returnValue);
	}

}
