package com.spring.starwars.services;

import com.spring.starwars.dtos.PersonajeDTO;
import com.spring.starwars.exceptions.PersonajeException;

import java.util.List;

public interface PersonajeService {
    public List<PersonajeDTO> buscarPersonajes(String filtro) throws PersonajeException;
}
