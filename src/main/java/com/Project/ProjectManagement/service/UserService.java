package com.Project.ProjectManagement.service;

import com.Project.ProjectManagement.entity.Role;
import com.Project.ProjectManagement.entity.User;
import com.Project.ProjectManagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public User signup(User user) {//회원가입
        if (userRepository.existsByLoginId(user.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));//비밀번호 해시
        user.setRole(Role.USER); //이건 역할 일단 디폴트로 사용자 설정
        return userRepository.save(user);
    }

}
