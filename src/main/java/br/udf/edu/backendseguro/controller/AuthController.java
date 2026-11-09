package br.edu.udf.backendseguro.controller;

import br.edu.udf.backendseguro.service.TokenService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public String login(Authentication authentication) {
        if (authentication == null) {
            throw new IllegalArgumentException("Selecione a opção Basic Auth no Bruno e informe o utilizador admin e palavra-passe 123456.");
        }
        return tokenService.gerarToken(authentication);
    }
}