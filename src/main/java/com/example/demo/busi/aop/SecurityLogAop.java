package com.example.demo.busi.aop;

/**
 * <p>
 * <b>Class name</b>: SecurityLogAop
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
 * 2020-01-02    zhang ying        1.0          Initial Creation
 *
 * </pre>
 *
 * @author zhang ying
 * @date 2020-01-02
 * </p>
 */

import com.example.demo.busi.model.SecurityLogInfo;
import com.example.demo.busi.model.annotation.SecurityLog;
import com.example.demo.busi.model.enums.EDataAction;
import com.example.demo.busi.model.enums.EDataEntity;
import com.example.demo.busi.model.enums.EDataId;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

/**
 * 使用Aop、注解、Spring语言表达式等技术操作日志的存储
 * 1、新建一个annotation，该注解作用于要记录日志的方法。
 * 2、该注解提供方法所属的模块、操作类型、操作对象的id（获取id用于获取操作对象）。
 * 3、操作对象id通过spring语言表达是的方式存在于注解的某个属性中。
 */
@Aspect
@Component
@Slf4j
public class SecurityLogAop {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @Around(value = "@annotation(log)")
    public Object doAround(ProceedingJoinPoint joinPoint, SecurityLog log) throws Throwable {
        EDataEntity entity = log.entity();
        EDataAction action = log.action();
        EDataId idType = log.idType();
        String idPath = log.idPath();

        //上下文用户存储方法参数名、参数值
        StandardEvaluationContext context = new StandardEvaluationContext();
        ExpressionParser parser = new SpelExpressionParser();

        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        //获取参数名称
        String[] parameterNames = signature.getParameterNames();
        //获取方法参数值
        Object[]  args = joinPoint.getArgs();

        if (null != args) {
            if (null != args) {
                for (int i = 0; i < parameterNames.length; i++) {
                    //参数名为key，参数值为value存入map
                    context.setVariable(parameterNames[i], args[i]);
                }
            }
        }
        Object result = joinPoint.proceed();
        try {
            Object value = parser.parseExpression(idPath).getValue(context);
            String id = objectMapper.writeValueAsString(value);
            SecurityLogInfo.builder()
                    .operatorId(999L)
                    .entity(entity)
                    .act(action)
                    .idType(idType)
                    .id(id)
                    .build();

//            applicationContext.publishEvent(SecurityLogInfo.class);
        }  catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return result;
    }
}
