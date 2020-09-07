/*
 *  Project Name: andfleethe
 *
 *  File Name: ModelUtil.java
 *
 *  Create Date: 2018-8-29
 *
 *  Copyright(c) 2018 CMIM Network Co.,Ltd. All Rights Reserved.
 */

package com.example.demo.busi.util;

import com.example.demo.busi.entity.SysUserEntity;
import com.example.demo.busi.model.UserInfoModel;

public final class ModelUtil {

    private ModelUtil() {
    }


    public static UserInfoModel trans(SysUserEntity sysUser) {

        if (sysUser == null) {
            return null;
        }

        UserInfoModel model = UserInfoModel.builder()
                .id(sysUser.getId())
                .email(sysUser.getEmail())
                .locked(sysUser.getLocked())
                .phone(sysUser.getPhone())
                .realname(sysUser.getRealname())
                .username(sysUser.getUsername())
                .text(sysUser.getRealname())
                .build();

        return model;
    }

}
