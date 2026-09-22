package com.Project.ProjectManagement.controller;

import com.Project.ProjectManagement.dto.user.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController{
    private final AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public void login(@RequestBody LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(//security 통해 인증 확인
                        new UsernamePasswordAuthenticationToken(//인증 요청 객체
                                request.getLoginId(),
                                request.getPassword()
                        )
                );
        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
    }
}
