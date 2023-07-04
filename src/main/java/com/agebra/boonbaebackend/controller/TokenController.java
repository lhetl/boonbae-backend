package com.agebra.boonbaebackend.controller;

import com.agebra.boonbaebackend.domain.Users;
import com.agebra.boonbaebackend.dto.UserDto;
import com.agebra.boonbaebackend.service.JwtService;
import com.agebra.boonbaebackend.service.UserService;
import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class TokenController {

  private final UserService userService;
  private final JwtService jwtService;

  @GetMapping("/token/validate")
  public ResponseEntity<Map<String, Object>> validateJwtToken(@AuthenticationPrincipal Users user) {
    Map<String, Object> response = new HashMap<>();

    boolean isValid = jwtService.isTokenValidByUsers(user);

    response.put("isValid", isValid);
    return ResponseEntity.ok(response);
  }

}
