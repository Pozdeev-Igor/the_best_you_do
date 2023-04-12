package com.example.thebest_youdo.service.impl;

import com.example.thebest_youdo.model.dto.request.AuthenticationRequest;
import com.example.thebest_youdo.model.dto.request.RegisterRequest;
import com.example.thebest_youdo.model.dto.responce.AuthenticationResponse;
import com.example.thebest_youdo.model.entity.Authority;
import com.example.thebest_youdo.model.entity.User;
import com.example.thebest_youdo.repository.AuthorityRepository;
import com.example.thebest_youdo.repository.UserRepository;
import com.example.thebest_youdo.security.jwt.JwtService;
import com.example.thebest_youdo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final AuthorityRepository authRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        Authority authority = new Authority();
        authority.setAuthorityName(request.getRole());

        User newUser = User.builder()
                .username(request.getUsername())
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .authorities(Collections.singletonList(authority))
                .dayStart(LocalDate.now())
                .count(0L)
                .rate(0.0f)
                .build();

        authority.setUser(newUser);
        userRepository.save(newUser);
        authRepo.save(authority);

        String token = jwtService.generateToken(newUser, newUser);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()));

        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user, user);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }
}
