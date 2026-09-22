package com.Project.ProjectManagement.service;

import com.Project.ProjectManagement.dto.user.UserResponse;
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
        if (userRepository.existsByLoginId(user.getLoginId())) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));//비밀번호 해시
        user.setRole(Role.USER); //이건 역할 일단 디폴트로 사용자 설정
        return userRepository.save(user);
    }

    public UserResponse getMyInfo(String loginId) {
        User user = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        return new UserResponse(
                user.getLoginId(),
                user.getEmail(),
                user.getName()
        );
    }

}
