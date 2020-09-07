package com.example.demo.busi.test;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

/**
 * <p>
 * <b>Class name</b>: User
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
@Component("user")
@Data
public class User {

    @Value("598")
    private Long id;

    @Value("zhang")
    private String firstName;

    @Value("ying")
    private String lastName;

    @Value("#{user.firstName.concat(' ').concat(user.lastName)}")
    private String fullName;

    public User() {}
}
