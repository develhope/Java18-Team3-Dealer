package com.develhope.spring.authentication.dto.request;

import com.develhope.spring.User.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private Integer telephoneNumber;
    private String email;
    private String password;
    private Role role;
}
