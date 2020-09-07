package com.example.demo.busi.api.aopTest;

import com.example.demo.busi.util.ArithmeticCalculator;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * <b>Class name</b>: AopTestApi
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
@RestController
@RequestMapping("/aop")
@Validated
@SwaggerDefinition(info = @Info(title = "Internal User API", version = "1.0.0"))
public class AopTestApi {

    @PutMapping("/test")
    public Integer aopTest(@RequestParam Integer num1, @RequestParam Integer num2) {
        ArithmeticCalculator arithmetic = new ArithmeticCalculator();
        return arithmetic.add(num1, num2);
    }


    @PutMapping("/test1")
    public void aopTest1() {
        ArithmeticCalculator arithmetic = new ArithmeticCalculator();
        arithmetic.div(3, 0);
    }

    @PutMapping("/test2")
    public void aopTest2() {
        ArithmeticCalculator arithmetic = new ArithmeticCalculator();
        arithmetic.add(3, 100);
    }
}
