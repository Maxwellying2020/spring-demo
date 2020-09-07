package com.example.demo.busi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

//    @Autowired
//    MemberMapper memberMapper;

    @Test
    public void test(){
        Map<String,Object> map = new HashMap();
        map.put("start",0);
        map.put("size",8);
//        List<SysUserEntity> list = memberMapper.list(map);
//        System.out.println("size:"+list.size());
        System.out.println("-----测试完毕-------");

    }

}
