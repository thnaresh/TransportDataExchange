package com.transportdataexchange.bogdan.controller;

import com.transportdataexchange.bogdan.model.AuthRequest;
import com.transportdataexchange.bogdan.model.User;
import com.transportdataexchange.bogdan.repository.UserRepository;
import com.transportdataexchange.bogdan.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Controller
public class BogdanController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String loginPage() {
        return "login"; // Show the login page
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());  // Create an empty User object for form binding
        return "register"; // Render the Thymeleaf registration form
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        // Check if the username already exists in the database
        if (userRepository.findByusername(user.getUsername()) != null) {
            model.addAttribute("error", "Username already exists.");
            return "register";  // Show error message on the registration form
        }

        // Encrypt the password before saving
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);  // Set the encoded password
        // Save the new user to the database
        userRepository.save(user);

        // Add a success message to the model
        model.addAttribute("successMessage", "Registration successful! Please login.");

        return "register"; // Return to the registration page with success message
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, String>> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        // Authenticate the user using username and password
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        // Retrieve the user from the database based on the username
        User user = userRepository.findByusername(authRequest.getUsername());
        if (user == null) {
            // This exception will be handled globally by the GlobalExceptionHandler
            throw new UsernameNotFoundException("User not found");
        }

        // Get the role from the user object (you have a single role here, so no need for a Set)
        Set<String> roles = new HashSet<>();
        roles.add(user.getRole()); // Since you have only one role, add it directly

        // Generate the JWT token
        String token = jwtUtil.generateToken(authRequest.getUsername(), roles);
        System.out.println("Generated token: " + token);

        // Return the token in the response
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }
}
