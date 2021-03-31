package com.spring.starwars.controllers;

import com.spring.starwars.dtos.ErrorDTO;
import com.spring.starwars.exceptions.PersonajeException;
import com.spring.starwars.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonajeController {

    @Autowired
    private PersonajeService service;

    @PostMapping("/buscar")
    public ResponseEntity filtrarPorNombre(@RequestParam String filter) throws PersonajeException {
        return new ResponseEntity(service.buscarPersonajes(filter), HttpStatus.OK);
    }

    @ExceptionHandler(PersonajeException.class)
    public ResponseEntity personajeNoEncontrado(PersonajeException e) {
        ErrorDTO err = new ErrorDTO();
        err.setDescription(e.getMessage());
        return new ResponseEntity(err, HttpStatus.NOT_FOUND);
    }

}
