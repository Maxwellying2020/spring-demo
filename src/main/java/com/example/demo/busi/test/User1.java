package com.example.demo.busi.test;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
@Component("user1")
@Data
public class User1 {

    private Long id = 1001L;

    private String firstName = "haha";

    private String lastName = "hehe";

    private String fullName;

    public User1() {
        this.fullName = firstName + lastName;
    }
}
