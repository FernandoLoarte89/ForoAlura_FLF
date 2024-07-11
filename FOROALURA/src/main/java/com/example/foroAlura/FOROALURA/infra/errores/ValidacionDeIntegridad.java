package com.example.foroAlura.FOROALURA.infra.errores;

public class ValidacionDeIntegridad extends RuntimeException {
    public ValidacionDeIntegridad(String s){
        super(s);
    }
}
