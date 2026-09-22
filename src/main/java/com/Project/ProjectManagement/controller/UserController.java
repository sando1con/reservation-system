package com.Project.ProjectManagement.controller;

import com.Project.ProjectManagement.dto.user.SignupRequest;
import com.Project.ProjectManagement.dto.user.UserResponse;
import com.Project.ProjectManagement.entity.User;
import com.Project.ProjectManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public User signup(@RequestBody SignupRequest request) {
        User user = new User();

        user.setLoginId(request.getLoginId());
        System.out.println(request.getPassword());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setName(request.getName());

        return userService.signup(user);
    }

    @GetMapping("/me")
    public UserResponse getMyInfo(Authentication authentication) {
        return userService.getMyInfo(authentication.getName());
    }
}
