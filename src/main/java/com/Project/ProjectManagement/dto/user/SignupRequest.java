package com.Project.ProjectManagement.dto.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignupRequest {
    private String loginId;
    private String password;
    private String email;
    private String name;
}
