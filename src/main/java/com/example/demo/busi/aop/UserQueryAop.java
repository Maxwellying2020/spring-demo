package com.example.demo.busi.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * <p>
 * <b>Class name</b>: UserQueryAop
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
public class UserQueryAop {

    @Pointcut("execution(* com.example.demo.busi.api.user.UserApi.findUserByUserId(..))")
    public void findUser() {
        log.info("enter findUser() function!");
    }

    @Before("findUser()")
    public void before() {
        log.info("我已经切入进来了！");
    }

    @After("findUser()")
    public void after() {
        log.info("运行到我这原来的程序已经执行完成！");
    }

    @Around("findUser()")
    public Object around(ProceedingJoinPoint pdj) {
        Object result = null;
        String methodName = pdj.getSignature().getName();

        System.out.println("前置通知方法>目标方法名：" + methodName + ",参数为：" + Arrays.asList(pdj.getArgs()));

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
}
