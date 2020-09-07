/*
 * Project Name: andfleethe
 *
 * File Name: RoleCategory.java
 *
 * Create Date: 2018-8-25
 *
 * Copyright(c) 2018 CMIM Network Co.,Ltd. All Rights Reserved.
 */

package com.example.demo.busi.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p>
 * <b>Class name</b>: RoleCategory
 * </p>
 * <p>
 * <b>Class description</b>: Class description goes here.
 * </p>
 * <p>
 * <b>Author</b>: peijunlong
 * </p>
 * <b>Change History</b>:<br/>
 * <p>
 *
 * <pre>
 * Date          Author       Revision     Comments
 * ----------    ----------   --------     ------------------
 * 2018-08-25    peijunlong        1.0          Initial Creation
 *
 * </pre>
 *
 * </p>
 */
public enum RoleCategory {

    /**
     * 系统管理员
     */
    System_Admin("SA_SYS_ADMIN"),
    /**
     * 业务管理员
     */
    Business_Admin("SA_BUSI_ADMIN"),
    /**
     * 设备管理员
     */
    Device_Admin("DE_DEVICE_ADMIN"),
    /**
     * 终端安装工
     */
    Terminal_Install_Work("DE_DEVICE_INSTALLER"),
    /**
     * 企业管理员
     */
    Ent_Admin("BI_ENT_ADMIN"),
    /**
     * 部门管理员
     */
    Dept_Admin("BI_DEPT_ADMIN"),
    /**
     * 普通员工
     */
    Employee("BI_EMPLOYEE"),
    /**
     * 司机
     */
    DRIVER("BI_DRIVER"),
    /**
     * 用车人
     **/
    USER("BI_USER"),
    /**
     * 审批人
     **/
    AUDITOR("BI_AUDITOR"),
    /**
     * 调度员
     **/
    DISPATCHER("BI_DISPATCHER"),
    /**
     * 租户管理员
     */
    RENT_ADMIN("RT_ADMIN"),
    /**
     * 租户企业管理员
     */
    RENT_ENT_ADMIN("RT_ENT_ADMIN"),
    /**
     * 企业超级管理员
     */
    ENT_SUPER_ADMIN("ENT_SUPER_ADMIN");

    private String category;

    RoleCategory(String category) {
        this.category = category;
    }

    @JsonValue
    public String getCategory() {
        return category;
    }

    @JsonCreator
    public static RoleCategory create(String category) {
        for (RoleCategory roleCategory : RoleCategory.values()) {
            if (roleCategory.getCategory().equals(category)) {
                return roleCategory;
            }
        }

        return null;
    }
}
