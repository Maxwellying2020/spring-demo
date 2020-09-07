package com.example.demo.test.api;


import com.example.demo.busi.DemoApplication;
import com.example.demo.busi.api.user.UserApi;
import com.example.demo.busi.dao.UserRepository;
import com.example.demo.busi.model.UserInfoModel;
import com.example.demo.busi.service.UserService;
import com.example.demo.test.base.BaseTest;
import com.example.demo.test.base.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.when;

/**
 * <p>
 * <b>Class name</b>: UserApiTest
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
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserApiTest extends BaseTest {
    private static final Long userId = 1L;

    @Autowired
    private UserApi userApi;

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;


    @Test(timeout = 1000)
    public void testTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Complete");
    }

    @Test(expected = NullPointerException.class)
    public void testNullException() {
        throw new NullPointerException();
    }

    @Test
    public void testFindUserByUserId() {
//        when(userService.findUserByUserId(userId)).thenReturn(TestData.sysUserEntity);
        when(userRepository.getOne(userId)).thenReturn(TestData.sysUserEntity);
        UserInfoModel userInfoModel = userApi.findUserByUserId(userId);
        assert(userInfoModel != null);
    }


}
