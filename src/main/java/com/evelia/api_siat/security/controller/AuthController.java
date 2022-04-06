package com.evelia.api_siat.security.controller;

import com.evelia.api_siat.security.dto.JwtDto;
import com.evelia.api_siat.security.dto.User;
import com.evelia.api_siat.security.entity.Usuario;
import com.evelia.api_siat.security.jwt.JwtUtil;

import com.evelia.api_siat.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.NoOp;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    JwtUtil JwtUtil;

 	@PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody User User, BindingResult bindingResult){
    	if(bindingResult.hasErrors())
            return new ResponseEntity("campos mal puestos", HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(User.getUsuario(), User.getPassword()));      
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Usuario user = usuarioService.getByUsuario(User.getUsuario()).get();
        String jwt = JwtUtil.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, user.getId(),userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
