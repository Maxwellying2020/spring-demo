package com.example.demo.busi.api.test;

import com.example.demo.busi.test.User;
import com.example.demo.busi.test.User1;
import com.example.demo.busi.util.ArithmeticCalculator;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * <b>Class name</b>: TestApi
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
 * 2019-12-27    zhang ying        1.0          Initial Creation
 *
 * </pre>
 *
 * @author zhang ying
 * @date 2019-12-27
 * </p>
 */
@RestController
@RequestMapping("/test")
@Validated
@SwaggerDefinition(info = @Info(title = "Internal User API", version = "1.0.0"))
public class TestApi {

    @Value("#{user.firstName.concat(' ').concat(user.lastName)}")
    private String fullName;

    @Value("#{T(System).currentTimeMillis()}")
    private Long currentTimeMillis;

    @PutMapping("/hello")
    public void test1(@Value("hello") String val ) {
        System.out.println("fullName:" + fullName + " val is " + val);
        System.out.println(currentTimeMillis);
    }

    @PutMapping("/hello2")
    public void test2() {
        //1、ExpressionParser获取bean的属性值
        User1 user = new User1();
        ExpressionParser expressionParser = new SpelExpressionParser();
        StandardEvaluationContext testContext = new StandardEvaluationContext(user);

        Object value = expressionParser.parseExpression("id").getValue(testContext);
        System.out.println("id:" + value);

        Expression expression1 = expressionParser.parseExpression("firstName");
        String firstName = expression1.getValue(testContext, String.class);
        System.out.println("firstName:" + firstName);

        Expression expression2 = expressionParser.parseExpression("fullName");
        String fullName = expression2.getValue(testContext, String.class);
        System.out.println("fullName:" + fullName);


        //2、1、ExpressionParser直接获取SpEL的值，没有context
        //Literal expression
        Expression expression = expressionParser.parseExpression("'Hello SpEL'");
        String strVal = expression.getValue(String.class);
        System.out.println(strVal);
    }
}
