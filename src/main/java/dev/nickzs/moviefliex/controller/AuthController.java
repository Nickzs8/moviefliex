package dev.nickzs.moviefliex.controller;

import dev.nickzs.moviefliex.config.TokenService;
import dev.nickzs.moviefliex.controller.request.LoginRequest;
import dev.nickzs.moviefliex.controller.request.UserRequest;
import dev.nickzs.moviefliex.controller.response.LoginResponse;
import dev.nickzs.moviefliex.controller.response.UserResponse;
import dev.nickzs.moviefliex.entity.User;
import dev.nickzs.moviefliex.mapper.UserMapper;
import dev.nickzs.moviefliex.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moviefliex/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request){
        User newUser = userService.save(UserMapper.toUser(request));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserMapper.toUserResponse(newUser));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        UsernamePasswordAuthenticationToken userAndPass =
                new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authenticate = authenticationManager.authenticate(userAndPass);

        User user = (User) authenticate.getPrincipal();

        String token = tokenService.generateToken(user);

        return ResponseEntity.ok(new LoginResponse(token));

    }
}
