package com.example.demo.busi.dao;

import com.example.demo.busi.entity.SysUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository<SysUserEntity, Long>,
        JpaSpecificationExecutor<SysUserEntity> {

    List<SysUserEntity> findByUsernameContaining(String username);
}
