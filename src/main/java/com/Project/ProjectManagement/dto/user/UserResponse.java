package com.Project.ProjectManagement.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {
    private String loginId;
    private String email;
    private String name;
}
