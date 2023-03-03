package com.jaeshim.inflearn.spring.start.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

  @Around("execution(* com.jaeshim.inflearn.spring.start..*(..))")
  public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
    //시간측정로직 추가
    long start = System.currentTimeMillis();
    System.out.println("START: "+joinPoint.toString());
    try {
      return joinPoint.proceed();
    } finally {
      long finish = System.currentTimeMillis();
      long timeMs = finish - start;
      System.out.println("END: "+joinPoint.toString()+" "+timeMs+"ms");
    }


  }
}
