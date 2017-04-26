/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Person;
import java.security.MessageDigest;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Konrad Juszkiewicz <kjuszkiewicz95 at gmail.com>
 */
@Service
public class AuthenticationService {

    @Autowired
    UserService userService;

    public AuthenticationService() {

    }

    public boolean authenticate(String email, String password) {
        String hashedPassword = hash(password);
        Person user = userService.getUserByEmail(email);
        if (user != null) {
            if (hashedPassword != null && user.getPassword() != null) {
                return user.getPassword().equals(hashedPassword);
            }
        }

        return false;
    }

    public String hash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            String str = new String(md.digest());
            return str;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
