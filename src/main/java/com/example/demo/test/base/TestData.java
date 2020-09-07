package com.example.demo.test.base;

import com.example.demo.busi.entity.SysUserEntity;
import com.example.demo.busi.model.UserInfoModel;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * <b>Class name</b>: TestData
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
//初始化数据
@Data
public class TestData {
    public static UserInfoModel userInfoModel;

    public static SysUserEntity sysUserEntity;

    public static void init() {
        userInfoModel = UserInfoModel.builder()
                .username("Tester")
                .email("659151@qq.com")
                .organizationId(1L)
                .password("123456")
                .realname("张三")
                .roleId(1L)
                .roleName("企业管理员")
                .phone("15072440508")
                .build();

        sysUserEntity = SysUserEntity.builder()
                .username("Tester")
                .email("659151@qq.com")
                .password("123456")
                .realname("张三")
                .phone("15072440508")
                .createTime(new Date())
                .updateTime(new Date())
                .build();
    }
}
