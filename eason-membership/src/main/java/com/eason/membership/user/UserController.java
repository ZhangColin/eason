package com.eason.membership.user;

import com.cartisan.constants.CodeMessage;
import com.cartisan.dtos.PageResult;
import com.cartisan.exceptions.CartisanException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cartisan.responses.ResponseUtil.success;

@Api(tags = "会员：用户")
@RestController
@RequestMapping("/users")
@Validated
@Slf4j
public class UserController {
    private final UserAppService service;

    public UserController(UserAppService service) {
        this.service = service;
    }

    @ApiOperation(value = "搜索用户")
    @GetMapping("/search")
    public ResponseEntity<PageResult<UserDto>> searchUsers(
            @ApiParam(value = "查询参数") UserQuery userQuery,
            @PageableDefault Pageable pageable) {
        return success(service.searchUsers(userQuery, pageable));
    }

    @ApiOperation(value = "获取用户")
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@ApiParam(value = "用户Id", required = true) @PathVariable Long id){
        return success(service.getUser(id));
    }

    @ApiOperation(value = "添加用户")
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(
            @ApiParam(value = "用户信息", required = true) @Validated @RequestBody UserParam userParam) {
        return success(service.addUser(userParam));
    }

    @ApiOperation(value = "添加用户")
    @PostMapping
    public ResponseEntity<UserDto> addUser(
            @ApiParam(value = "用户信息", required = true) @Validated @RequestBody UserParam userParam) {
        return success(service.addUser(userParam));
    }

    @ApiOperation(value = "编辑用户")
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> editUser(
            @ApiParam(value = "用户Id", required = true) @PathVariable Long id,
            @ApiParam(value = "用户信息", required = true) @Validated @RequestBody UserParam userParam) {
        return success(service.editUser(id, userParam));
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeUser(
            @ApiParam(value = "用户Id", required = true) @PathVariable Long id) {
        service.removeUser(id);
        return success();
    }
}
