package com.example.demo.test.base;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;

import static org.mockito.Mockito.reset;

/**
 * <p>
 * <b>Class name</b>: BaseTest
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
 * 2019-03-20    zhang ying        1.0          Initial Creation
 *
 * </pre>
 *
 * @author zhang ying
 * @date 2019-03-20
 * </p>
 */
@Slf4j
public class BaseTest {

    @Before
    public void setUp() throws Exception{
        log.info("Data Init");
        //初始化数据
        TestData.init();

    }

    @After
    public void clean(){
        log.info("Data Clean");
        TestData.init();
        reset();
    }
}
