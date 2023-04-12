package com.example.thebest_youdo.model.dto.request;


import com.example.thebest_youdo.model.entity.Authority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String username;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String role;

}
