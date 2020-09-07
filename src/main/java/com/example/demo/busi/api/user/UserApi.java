package com.example.demo.busi.api.user;

import com.example.demo.busi.model.UserInfoModel;
import com.example.demo.busi.model.annotation.SecurityLog;
import com.example.demo.busi.model.enums.EDataAction;
import com.example.demo.busi.model.enums.EDataEntity;
import com.example.demo.busi.model.enums.EDataId;
import com.example.demo.busi.service.UserService;
import com.example.demo.busi.util.ModelUtil;
import com.example.model.demo.request.CreateUserDto;
import com.example.model.demo.request.UpdateUserDto;
import com.example.util.global.RequestManager;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@Validated
@SwaggerDefinition(info = @Info(title = "Internal User API", version = "1.0.0"))
public class UserApi {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public UserInfoModel create(@RequestBody  @Valid @NotNull CreateUserDto dto) {
        return ModelUtil.trans(userService.create(dto));
    }

    @PutMapping("/delete/{id}")
    @SecurityLog(entity = EDataEntity.USER, action = EDataAction.DELETE)
    public void delete(@PathVariable("id") Long id) {
        System.out.println("only for test save log function！" + id);
    }


    @PutMapping("/update/{id}")
    @SecurityLog(entity = EDataEntity.USER, action = EDataAction.UPDATE, idType = EDataId.ID, idPath = "#dto.id")
    public UserInfoModel update(@PathVariable("id")Long id, @RequestBody  @Valid @NotNull UpdateUserDto dto) {
        return ModelUtil.trans(userService.update(dto));
    }

    @GetMapping("/findUserByUserId/{user-id}")
    public UserInfoModel findUserByUserId(@PathVariable("user-id") Long userId) {
        return ModelUtil.trans(userService.findUserByUserId(userId));
    }

    @GetMapping("/findUserListByUsername/{username}")
    public List<UserInfoModel> findUserListByUsername(@PathVariable("username") String username) {
        return userService.findUserListByUsername(username).stream().map(ModelUtil::trans).collect(Collectors.toList());
    }

    @GetMapping("/findAllUser")
    public List<UserInfoModel> findAllUser() {
        HttpServletRequest request = RequestManager.getHttpServletRequest();
        System.out.println(request);
        return userService.findAllUser().stream().map(ModelUtil::trans).collect(Collectors.toList());
    }

}
