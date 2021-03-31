package com.spring.starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.starwars.dtos.PersonajeDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository {
    @Override
    public List<PersonajeDTO> cargarPersonajes() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonajeDTO>> typeReference = new TypeReference<List<PersonajeDTO>>() {
        };
        List<PersonajeDTO> personajes = null;
        try {
            personajes = objectMapper.readValue(file, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personajes;
    }
}
