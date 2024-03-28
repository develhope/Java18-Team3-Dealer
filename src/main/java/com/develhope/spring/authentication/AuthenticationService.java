package com.develhope.spring.authentication;


import com.develhope.spring.authentication.dto.request.RefreshTokenRequest;
import com.develhope.spring.authentication.dto.request.SignUpRequest;
import com.develhope.spring.authentication.dto.request.SigninRequest;
import com.develhope.spring.authentication.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest request);
}
