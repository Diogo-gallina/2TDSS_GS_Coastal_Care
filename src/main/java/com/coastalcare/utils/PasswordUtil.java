package com.coastalcare.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    public static String encoder(String password){
        BCryptPasswordEncoder encoderPassword = new BCryptPasswordEncoder();
        return encoderPassword.encode(password);
    }

}
