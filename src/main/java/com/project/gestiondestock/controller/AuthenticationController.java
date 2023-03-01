package com.project.gestiondestock.controller;

import com.project.gestiondestock.controller.api.AuthenticationApi;
import com.project.gestiondestock.dto.auth.AuthenticationRequest;
import com.project.gestiondestock.dto.auth.AuthenticationResponse;
import com.project.gestiondestock.model.auth.ExtendedUser;
import com.project.gestiondestock.services.auth.ApplicationUserDetailsService;
import com.project.gestiondestock.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.project.gestiondestock.utils.Constants.AUTHENTICATION_ENDPOINT;


@RestController
public class AuthenticationController implements AuthenticationApi {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request) {
        /*authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        "cc",
                        "cc"
                )
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());

        final String jwt = jwtUtil.generateToken((ExtendedUser) userDetails);*/

        return ResponseEntity.ok(AuthenticationResponse.builder().accessToken("jwt").build());
    }

}