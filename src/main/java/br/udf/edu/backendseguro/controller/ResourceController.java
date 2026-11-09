package br.edu.udf.backendseguro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resource")
public class ResourceController {

    // Rota protegida (só entra quem tiver o Token JWT válido)
    @GetMapping("/hello")
    public String hello() {
        return "Acesso concedido. EndPoint Protegido!";
    }
}