package com.example.demo.test.api;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.List;
/**
 * <p>
 * <b>Class name</b>: ParameterTest
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
 * 2019-03-19    zhang ying        1.0          Initial Creation
 *
 * </pre>
 *
 * @author zhang ying
 * @date 2019-03-19
 * </p>
 */

/**
 * 参数化测试，允许开发人员使用不同的值反复运行同一个测试
 */

//1、更改默认的测试运行器为@RunWith(Parameterized.class)
@RunWith(Parameterized.class)
public class ParameterTest {
    //2、声明变量存放预期值和测试数据
    private String firstName;
    private String lastName;

    //3.声明一个返回值 为Collection的公共静态方法，并使用@Parameters进行修饰
    @Parameterized.Parameters
    public static List<Object[]> param() {
        // 这里我给出两个测试用例
        return Arrays.asList(new Object[][]{{"Mike", "Black"}, {"Cilcln", "Smith"}});
    }

    //4.为测试类声明一个带有参数的公共构造函数，并在其中为之声明变量赋值
    public ParameterTest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // 5. 进行测试，发现它会将所有的测试用例测试一遍
    @Test
    public void test() {
        String name = firstName + " " + lastName;
        Assert.assertThat("Cilcln Smith", CoreMatchers.is(name));
    }

}
