/*
 *  Project Name: andfleethe
 *
 *  File Name: UserInfoModel.java
 *
 *  Create Date: 2018-8-25
 *
 *  Copyright(c) 2018 CMIM Network Co.,Ltd. All Rights Reserved.
 */

package com.example.demo.busi.model;


import com.example.demo.busi.model.enums.RoleCategory;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@ApiModel(value = "UserInfoModel", description = "用户信息")
public class UserInfoModel implements Serializable {

    @ApiModelProperty("员工编号")
    private Long id; //编号
    @ApiModelProperty("员工所在机构Id")
    private Long organizationId; //所属公司
    @ApiModelProperty("员工所在机构code")
    private String organizationCode;
    @ApiModelProperty("员工所在机构部门名称")
    private String deptName; //所属部门名称
    @ApiModelProperty("员工所在企业名称")
    private String entName; //所属企业名称
    @ApiModelProperty("员工所在企业id")
    private Long entId; //所属企业id
    @ApiModelProperty("员工用户名")
    private String username; //用户名
    @ApiModelProperty("员工角色Id")
    private Long roleId; //拥有的角色列表
    @ApiModelProperty("员工角色名称")
    private String roleName;
    @ApiModelProperty("角色编码")
    private String roleCode;
    @ApiModelProperty("员工角色模板名称")
    private String roleTemplate;
    @ApiModelProperty("员工真实姓名")
    private String realname;
    @ApiModelProperty("员工手机号码")
    private String phone;
    @ApiModelProperty("员工电子邮箱")
    private String email;
    @ApiModelProperty("员工是否锁定")
    private Boolean locked = Boolean.FALSE;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("TOKEN")
    private String token;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("盐")
    private String salt;
    @ApiModelProperty("用户类别")
    private RoleCategory category;
    //    @ApiModelProperty("岗位信息列表")
//    private List<PositionInfoModel> positions;
    @ApiModelProperty("节点名称")
    private String text;//为方便前端构造部门员工树，添加此字段
    @ApiModelProperty("角色类型")
    private String catCode;


    //超级管理员
    @JsonIgnore
    public boolean isSuperAdmin() {
        return (
                RoleCategory.System_Admin.equals(category)
                        || RoleCategory.Business_Admin.equals(category)
                        || RoleCategory.Device_Admin.equals(category)
        ) ? true : false;
    }

    //是否是系统管理员
    @JsonIgnore
    public boolean isSysAdmin() {
        return RoleCategory.System_Admin.equals(category) ? true : false;
    }

    //租户管理员
    @JsonIgnore
    public boolean isRentAdmin() {
        return RoleCategory.RENT_ADMIN.equals(category) ? true : false;
    }

    //企业管理员
    @JsonIgnore
    public boolean isEntAdmin() {
        return (RoleCategory.Ent_Admin.equals(category)) ? true : false;
    }

    //超级企业管理员
    @JsonIgnore
    public boolean isEntSuperAdmin() {
        return (RoleCategory.ENT_SUPER_ADMIN.equals(category)) ? true : false;
    }

    //OW 业务管理员
    @JsonIgnore
    public boolean isBusiAdmin() {
        return (RoleCategory.Business_Admin.equals(category));
    }

    //部门管理员
    @JsonIgnore
    public boolean isDeptAdmin() {
        return RoleCategory.Dept_Admin.equals(category) ? true : false;
    }

    //企业或部门管理员
    @JsonIgnore
    public boolean isEntOrDeptAdmin() {
        return RoleCategory.Ent_Admin.equals(category) || RoleCategory.Dept_Admin.equals(category) ? true : false;
    }

    //员工
    @JsonIgnore
    public boolean isEndUser() {
        return RoleCategory.Employee.equals(category) ? true : false;
    }

    //司机
    @JsonIgnore
    public boolean isDriver() {
        return RoleCategory.DRIVER.equals(category) ? true : false;
    }

    //租车公司管理员(特殊企业管理员)
    @JsonIgnore
    public boolean isRentEnterpriseAdmin() {
        return RoleCategory.RENT_ENT_ADMIN.equals(category) ? true : false;
    }

    /**
     * 判断用户角色是否为终端安装工
     *
     * @return
     */
    @JsonIgnore
    public boolean isDeviceInstallWorker() {
        return RoleCategory.Terminal_Install_Work.equals(category) ? true : false;
    }

    /**
     * 判断用户角色是否为设备管理员
     *
     * @return
     */
    @JsonIgnore
    public boolean isDeviceAdmin() {
        return RoleCategory.Device_Admin.equals(category) ? true : false;
    }

}
