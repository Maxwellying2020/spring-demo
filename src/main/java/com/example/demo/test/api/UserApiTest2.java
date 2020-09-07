package com.example.demo.test.api;

import com.example.demo.busi.api.user.UserApi;
import com.example.demo.busi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <p>
 * <b>Class name</b>: UserApiTest2
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
@WebMvcTest(com.example.demo.busi.api.user.UserApi.class)
@SpringBootTest
public class UserApiTest2 {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    public void setUp() {
        // 数据打桩，设置该方法返回的 body一直 是空的
        Mockito.when(userService.findAllUser()).thenReturn(new ArrayList<>());
    }

    @Test
    public void listAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user"))
                .andExpect(status().isOk()) // 期待返回状态吗码200
                // JsonPath expression  https://github.com/jayway/JsonPath
                //.andExpect(jsonPath("$[1].name").exists()) // 这里是期待返回值是数组，并且第二个值的 name 存在，所以这里测试是失败的
                .andDo(print()); // 打印返回的 http response 信息
    }

}
