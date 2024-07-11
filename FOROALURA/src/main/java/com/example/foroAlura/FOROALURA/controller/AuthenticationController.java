package com.example.foroAlura.FOROALURA.controller;

import com.example.foroAlura.FOROALURA.domain.usuario.AutenticacionUsuario;
import com.example.foroAlura.FOROALURA.domain.usuario.Usuario;
import com.example.foroAlura.FOROALURA.infra.security.JWTToken;
import com.example.foroAlura.FOROALURA.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<JWTToken> autenticarUsuario(@RequestBody @Valid AutenticacionUsuario autenticacionUsuario){
        Authentication authToken = new UsernamePasswordAuthenticationToken(autenticacionUsuario.nombre(),
                autenticacionUsuario.clave());
        authenticationManager.authenticate(authToken);
        var UsuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWToken = tokenService.generarToken((Usuario) UsuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new JWTToken(JWToken));
    }
}
