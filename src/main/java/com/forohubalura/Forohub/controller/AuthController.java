package com.forohubalura.Forohub.controller;

import com.forohubalura.Forohub.dominio.usuario.AuthData;
import com.forohubalura.Forohub.dominio.usuario.Usuario;
import com.forohubalura.Forohub.infraestructura.security.JWTTokenData;
import com.forohubalura.Forohub.infraestructura.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class AuthController {
    final
    AuthenticationManager authenticationManager;

    final
    TokenService tokenService;

    public AuthController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<JWTTokenData> autenticarUsuario(@RequestBody @Valid AuthData authData){
        Authentication authToken = new UsernamePasswordAuthenticationToken(authData.nombre(), authData.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new JWTTokenData(JWTtoken));

    }
}
