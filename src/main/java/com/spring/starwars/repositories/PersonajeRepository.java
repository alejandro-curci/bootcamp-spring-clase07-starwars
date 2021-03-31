package com.spring.starwars.repositories;

import com.spring.starwars.dtos.PersonajeDTO;

import java.util.List;

public interface PersonajeRepository {

    public List<PersonajeDTO> cargarPersonajes();
}
