package com.example.demo.busi.util;

import org.springframework.stereotype.Component;


/**
 * <p>
 * <b>Class name</b>: ArithmeticCalculator
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
@Component
public class ArithmeticCalculator {

    public Integer add (Integer num1, Integer num2) {
        return num1 + num2;
    }

    public Integer div (Integer num1, Integer num2) {
        return num1 / num2;
    }
}
