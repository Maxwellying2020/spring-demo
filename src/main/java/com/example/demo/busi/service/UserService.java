package com.example.demo.busi.service;

import com.example.demo.busi.dao.UserRepository;
import com.example.demo.busi.entity.SysUserEntity;
import com.example.model.demo.request.CreateUserDto;
import com.example.model.demo.request.UpdateUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService extends BaseService {

    @Autowired
    UserRepository userRepository;

    public SysUserEntity findUserByUserId(Long userId) {
        SysUserEntity user = userRepository.getOne(userId);
        log.info(user.toString());
        return userRepository.getOne(userId);
    }

    public List<SysUserEntity> findUserListByUsername(String username) {
        return userRepository.findByUsernameContaining(username);
    }

    public List<SysUserEntity> findAllUser() {
        return userRepository.findAll();
    }

    public SysUserEntity create(CreateUserDto dto) {

        final String REG_SIM_CODE = "^([0-9]{11}|[0-9]{13})$";
        if (dto.getUsername().matches(REG_SIM_CODE)) {
            System.out.println("匹配成功。。。。。。");
        } else {
            System.out.println("匹配失败。。。。");
        }

        SysUserEntity entity = new SysUserEntity();
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setRealname(dto.getRealname());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setOrganizationId(dto.getOrganizationId());
        entity.setRoleId(dto.getRoleId());
        return userRepository.save(entity);
    }

    public SysUserEntity update(UpdateUserDto dto) {
        log.info("user update successful!");
        SysUserEntity entity = new SysUserEntity();
        return entity;
//        SysUserEntity entity = userRepository.getOne(dto.getId());
//        entity.setRealname(dto.getRealname());
//        entity.setPhone(dto.getPhone());
//        entity.setEmail(dto.getEmail());
//        entity.setOrganizationId(dto.getOrganizationId());
//        entity.setRoleId(dto.getRoleId());
//        return userRepository.save(entity);
    }
}
