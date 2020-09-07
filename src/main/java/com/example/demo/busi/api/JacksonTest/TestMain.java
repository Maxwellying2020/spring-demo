package com.example.demo.busi.api.JacksonTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 * <b>Class name</b>: TestMain
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
 * 2020-01-06    zhang ying        1.0          Initial Creation
 *
 * </pre>
 *
 * @author zhang ying
 * @date 2020-01-06
 * </p>
 */
public class TestMain {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Friend friend = new Friend("yitian", 25);
        Integer num = 111;

        //写为字符串
        String str = objectMapper.writeValueAsString(friend);
        //从字符串中读出
        Friend newFriend = objectMapper.readValue(str, Friend.class);
        System.out.println(newFriend);

        //写为字节流
        byte[] bytes = objectMapper.writeValueAsBytes(friend);
        //从字节流中读出
        Friend newFriend1 = objectMapper.readValue(bytes, Friend.class);
        System.out.println(newFriend1);

        //写为文件
        objectMapper.writeValue(new File("friend.json"), friend);
        Friend newFriend3 = objectMapper.readValue(new File("friend.json"), Friend.class);
        System.out.println(newFriend3);
    }

}
