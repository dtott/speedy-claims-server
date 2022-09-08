package com.allstate.speedyclaimsserver.control;

import com.allstate.speedyclaimsserver.data.UserRepository;
import com.allstate.speedyclaimsserver.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @PostMapping()
    public Map<String, String> login(@RequestBody Map<String, String> loginData) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails)principal;
        String username = userDetails.getUsername();
        System.out.println("User is " + username);
        User user = userRepository.findByUsername(username);
        System.out.println("Role is " + user.getRole());

        Map<String, String> response = new HashMap<>();
        response.put("username", username);
        response.put("name", user.getName());
        response.put("role", user.getRole().toString());
        return response;
    }

}
