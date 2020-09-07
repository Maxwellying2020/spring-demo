/*
 *  Project Name: andfleethe
 *
 *  File Name: SysUserEntity.java
 *
 *  Create Date: 2018-8-30
 *
 *  Copyright(c) 2018 CMIM Network Co.,Ltd. All Rights Reserved.
 */

package com.example.demo.busi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "sys_user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial8")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

    @Column(name = "organization_id")
    private Long organizationId;

    @Column(name="role_id")
    private Long roleId;

    @Column(name = "realname")
    private String realname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "locked")
    private Boolean locked = false;

    @Column(name = "token")
    private String token;

    @Column(name = "iam_id")
    private Long iamId;

    @Column(name = "flag")
    private Integer flag = 0;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 7;
        result = prime * result + ((id == null) ? 0 : id.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        SysUserEntity other = (SysUserEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;


        return true;
    }


    @Override
    public String toString() {
        return "SysUserEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
