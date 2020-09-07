package com.example.demo.busi.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * <p>
 * <b>Class name</b>: AopDemo
 * </p>
 * <p>
 * <b>Class description</b>: Class description goes here.
 * </p>
 * <p>
 * <b>Author</b>: zhang ying
 * </p>
 * <b>Change History</b>:<br/>
 * <p>
 *
 * <pre>
 * Date          Author       Revision     Comments
 * ----------    ----------   --------     ------------------
 * 2019-12-25    zhang ying        1.0          Initial Creation
 *
 * </pre>
 *
 * @author zhang ying
 * @date 2019-12-25
 * </p>
 */
@Aspect
@Component
@Slf4j
public class AopTest {

    @Pointcut("execution(* com.example.demo.busi.api.aopTest.AopTestApi.*(..))")
//    @Pointcut("execution(* *(..))") 匹配所有的方法
    public void aopTest() {
        log.info("enter aopTest function!");
    }

    /**
     * 环绕通知，连接点被执行方法的前、中、后、异常时都可以执行
     */
    @Around("aopTest()")
    public Object around(ProceedingJoinPoint pdj) {
        Object result = null;
        String methodName = pdj.getSignature().getName();

        System.out.println("前置通知方法>目标方法名：" + methodName + ",参数为：" + Arrays.asList(pdj.getArgs()));

        //获取参数名称
        MethodSignature methodSignature = (MethodSignature) pdj.getSignature();
        String[] parameterNames = methodSignature.getParameterNames();

        //获取方法参数
        Object[] methodParam = pdj.getArgs();
        if (null != parameterNames) {

        }

        try {
            result = pdj.proceed();

            /*返回通知方法*/
            System.out.println("返回通知方法>目标方法名" + methodName + ",返回结果为：" + result);
        } catch (Throwable e) {
            /*异常通知方法*/
            System.out.println("异常通知方法>目标方法名" + methodName + ",异常为：" + e);
        }

        /*后置通知*/
        System.out.println("后置通知方法>目标方法名" + methodName);

        return result;
    }

    //方法返回值之后
    @AfterReturning("aopTest()")
    public void afterReturning() {
        log.info("enter afterReturning!");
    }

    //方法抛出异常
    @AfterThrowing("aopTest()")
    public void afterThrowing() {
        log.info("enter afterThrowing!");
    }


}
