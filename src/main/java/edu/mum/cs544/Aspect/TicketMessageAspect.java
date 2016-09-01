/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs544.Aspect;

/**
 *
 * @author seidabdu
 */
import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class TicketMessageAspect {
    
    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void controller() {}

    @Pointcut("execution(* *(..))")
    public void methodPointcut() {}

    @Pointcut("within(@org.springframework.web.bind.annotation.RequestMapping *)")
    public void requestMapping() {}

    @Before("controller() && methodPointcut() && requestMapping()")
    public void aroundControllerMethod(JoinPoint joinPoint) throws Throwable {
        System.out.println("Invoked: " + niceName(joinPoint));
    }

    @AfterReturning("controller() && methodPointcut() && requestMapping()")
    public void afterControllerMethod(JoinPoint joinPoint) {
        System.out.println("Finished: " + niceName(joinPoint));
    }

    private String niceName(JoinPoint joinPoint) {
        return joinPoint.getTarget().getClass()
                + "#" + joinPoint.getSignature().getName()
                + "\n\targs:" + Arrays.toString(joinPoint.getArgs());
    }


    
}
