package com.example.studentmanagementsystem.controllers.security;

import com.example.studentmanagementsystem.entities.User;
import com.example.studentmanagementsystem.entities.dto.AuthenticationDTO;
import com.example.studentmanagementsystem.entities.dto.RegisterDTO;
import com.example.studentmanagementsystem.entities.dto.LoginResponseDTO;
import com.example.studentmanagementsystem.infra.security.TokenService;
import com.example.studentmanagementsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticator;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getRegistration(), data.getPassword());
        var auth = this.authenticator.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok().body(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDTO data) {
        if(userRepository.findByRegistration(data.getRegistration()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        var user = new User(data.getRegistration(), encryptedPassword, data.getEmail(), data.getName(), data.getRole());

        this.userRepository.save(user);

        return ResponseEntity.ok().body(user);
    }
}
