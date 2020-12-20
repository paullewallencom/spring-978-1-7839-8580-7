package com.spring_cookbook.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Profiler {
	
	@Around("execution(* com.spring_cookbook.controllers.*.*(..))")
	  public Object doBasicProfiling(ProceedingJoinPoint joinPoint) throws Throwable {
		Long t1 = System.currentTimeMillis();
        Object returnValue = joinPoint.proceed();
        Long t2 = System.currentTimeMillis();        

        Long executionTime = t2 - t1;
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        
        System.out.println(className + "." + methodName + "() took " + executionTime + " ms");
        
        return returnValue;
    }
	 
}
