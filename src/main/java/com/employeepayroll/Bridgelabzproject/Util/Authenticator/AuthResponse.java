package com.employeepayroll.Bridgelabzproject.Util.Authenticator;

import com.employeepayroll.Bridgelabzproject.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private final User user;
    private final String jwt;

}
