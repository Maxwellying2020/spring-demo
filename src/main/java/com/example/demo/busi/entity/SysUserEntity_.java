/*
 * Project Name: andfleethe
 *
 * File Name: SysUserEntity_.java
 *
 * Create Date: 2018-8-24
 *
 * Copyright(c) 2018 CMIM Network Co.,Ltd. All Rights Reserved.
 */

package com.example.demo.busi.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(SysUserEntity.class)
public abstract class SysUserEntity_ {

    public static volatile SingularAttribute<SysUserEntity, String> salt;
    //	public static volatile SingularAttribute<SysUserEntity, SysRole> role;
    public static volatile SingularAttribute<SysUserEntity, Integer> flag;
    public static volatile SingularAttribute<SysUserEntity, Long> iamId;
    public static volatile SingularAttribute<SysUserEntity, String> username;
    public static volatile SingularAttribute<SysUserEntity, String> token;
    public static volatile SingularAttribute<SysUserEntity, String> realname;
    public static volatile SingularAttribute<SysUserEntity, String> password;
    public static volatile SingularAttribute<SysUserEntity, String> phone;
    //	public static volatile SingularAttribute<SysUserEntity, SysOrganization> organization;
    public static volatile SingularAttribute<SysUserEntity, Long> id;
    public static volatile SingularAttribute<SysUserEntity, Boolean> locked;
    public static volatile SingularAttribute<SysUserEntity, String> email;

}

