package com.eason.portal.service;

import com.eason.portal.request.RegisterCommand;
import com.eason.portal.response.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author colin
 */
@FeignClient(value = "eason-membership")
public interface UserService {
    @PostMapping(value = "/users/register")
    void register(@RequestBody RegisterCommand command);

    @GetMapping("/users/findByUserName")
    UserDto findByUserName(@RequestParam(value = "userName") String userName);
}
