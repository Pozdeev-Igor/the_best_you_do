package com.example.thebest_youdo.model.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String username;
    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private String phoneNumber;
    private List<String> authorities;

}
