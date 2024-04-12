package com.edu.xmu.rag.controller;

import com.edu.xmu.rag.controller.vo.MessageVo;
import com.edu.xmu.rag.controller.vo.UserVo;
import com.edu.xmu.rag.core.model.ReturnNo;
import com.edu.xmu.rag.core.model.ReturnObject;
import com.edu.xmu.rag.service.UserService;
import com.edu.xmu.rag.service.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("messagelist")
    public ReturnObject getMessageList() {
        return new ReturnObject(new MessageVo());
    }

    @PostMapping("/user/register")
    public ReturnObject createUser(@Validated @RequestBody UserVo userVo){
        ReturnObject user = userService.createUser(userVo.getName(), userVo.getPassword());
        return user;
    }

    @PostMapping("/user/login")
    public ReturnObject login(@Validated @RequestBody UserVo userVo){
        ReturnObject ret = userService.login(userVo.getName(), userVo.getPassword());
        return ret;
    }


}
