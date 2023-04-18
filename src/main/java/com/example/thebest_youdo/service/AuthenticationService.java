package com.example.thebest_youdo.service;

import com.example.thebest_youdo.model.dto.request.AuthenticationRequest;
import com.example.thebest_youdo.model.dto.request.RegisterRequest;
import com.example.thebest_youdo.model.dto.responce.AuthenticationResponse;
import com.example.thebest_youdo.model.entity.User;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    ResponseEntity<?> validateToken(String token);
}
