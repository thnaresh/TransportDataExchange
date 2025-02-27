package com.transportdataexchange.bogdan.controller;

import com.transportdataexchange.bogdan.model.AuthRequest;
import com.transportdataexchange.bogdan.model.BusData;
import com.transportdataexchange.bogdan.model.User;
import com.transportdataexchange.bogdan.repository.UserRepository;
import com.transportdataexchange.bogdan.service.BusDataService;
import com.transportdataexchange.bogdan.utility.JwtUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Controller
@Log4j2
public class BogdanController {
    @Autowired
    private BusDataService busDataService;
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
            return "register";
        }

        // Encrypt the password before saving
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        // Save the new user to the database
        userRepository.save(user);

        // Add a success message to the model
        model.addAttribute("successMessage", "Registration successful! Please login.");

        return "register";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, String>> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        // Authenticate the user using username and password
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        // Retrieve the user from the database based on the username
        User user = userRepository.findByusername(authRequest.getUsername());
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Get the role from the user object
        Set<String> roles = new HashSet<>();
        roles.add(user.getRole());

        // Generate the JWT token
        String token = jwtUtil.generateToken(authRequest.getUsername(), roles);
        log.info("Generated token: " + token);

        // Return the token and the appropriate redirect URL
        String redirectUrl = getRedirectUrlByRole(user.getRole());

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("redirectUrl", redirectUrl);
        return ResponseEntity.ok(response);
    }

//    @PostMapping("/saveBusData")
//    public ResponseEntity<String> uploadBusData(@RequestParam("file") MultipartFile file) {
//        try {
//            log.info("Entered in save bus data method");
//            busDataService.uploadBusData(file);
//            return ResponseEntity.ok("File uploaded and processed successfully.");
//        } catch (Exception e) {
//            log.error("Error occurred while processing the file: " + e.getMessage(), e);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error occurred while processing the file: " + e.getMessage());
//        }
//    }

    @PostMapping("/updateBusData")
    public ResponseEntity<?> updateBusData(@RequestBody List<BusData> updatedData) {
        for (BusData bus : updatedData) {
            busDataService.save(bus);
        }
        return ResponseEntity.ok().build();
    }





    private String getRedirectUrlByRole(String role) {
        switch (role) {
            case "admin":
                return "/bogdandashboard.html";
            case "operations":
                return "/bovadashboard.html";
            case "qa":
                return "/bristoldashboard.html";
            default:
                return "/login";
        }
    }


}
