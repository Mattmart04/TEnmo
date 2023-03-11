package com.techelevator.tenmo.controller;

import javax.validation.Valid;

import com.techelevator.tenmo.dao.AccountRepository;
import com.techelevator.tenmo.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.security.jwt.TokenProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Controller to authenticate users.
 */
@RestController
@Component
public class AuthenticationController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserDao userDao;
    private final AccountRepository accountRepository;

    public AuthenticationController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, UserDao userDao, AccountRepository accountRepository) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDao = userDao;
        this.accountRepository = accountRepository;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResponseDto login(@Valid @RequestBody LoginDto loginDto) {
        User user = userDao.findByUsername(loginDto.getUsername());
        user.setRole(user.getRole());
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword(), user.getAuthorities());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication, false);
        


        return new LoginResponseDto(jwt, user);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/register")
    public void register(@Valid @RequestBody RegisterUserDto newUser) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(newUser.getPassword());
        User user = new User(newUser.getUsername(), encryptedPassword, "USER");
        System.out.println(user);
        userDao.save(user);
        accountRepository.save(new Account(user));
    }

}

