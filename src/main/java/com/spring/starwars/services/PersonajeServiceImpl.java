package com.spring.starwars.services;

import com.spring.starwars.dtos.PersonajeDTO;
import com.spring.starwars.exceptions.PersonajeException;
import com.spring.starwars.repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeRepository repository;

    @Override
    public List<PersonajeDTO> buscarPersonajes(String filtro) throws PersonajeException {
        List<PersonajeDTO> personajes = repository.cargarPersonajes();
        List<PersonajeDTO> personajesResult = new ArrayList<>();
        if (!personajes.isEmpty()) {
            for (PersonajeDTO p : personajes) {
                if (p.getName().contains(filtro)) {
                    personajesResult.add(p);
                }
            }
        }
        if (personajesResult.isEmpty()) {
            throw new PersonajeException("No se ha encontrado ningun personaje");
        }
        return personajesResult;
    }
}
