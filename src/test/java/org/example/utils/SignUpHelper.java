package org.example.utils;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SignUpHelper {
    public String email;
    public String password;
    public ArrayList<String> roles;

    public SignUpHelper(String password) {
        this.email = generateEmail();
        this.password = password;
        roles = new ArrayList<>();
        roles.add("ROLE_USER");
    }

    private String generateEmail() {
        String timestamp = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
                .withZone(ZoneOffset.UTC)
                .format(Instant.now());
        return timestamp +"@example.com";
    }

    public String getEmail() {
        return email;
    }
}
