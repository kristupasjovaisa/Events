package eu.codeacademy.events.helper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passwordAdmin = "admin";
        String paswordGuest = "guest";
        String encodedPasswordAdmin = encoder.encode(passwordAdmin);
        String encodedPasswordGuest = encoder.encode(paswordGuest);
        System.out.println(encodedPasswordAdmin);
        System.out.println(encodedPasswordGuest);
    }
}
