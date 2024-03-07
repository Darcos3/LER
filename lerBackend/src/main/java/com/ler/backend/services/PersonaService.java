package com.ler.backend.services;

import com.ler.backend.entity.Persona;

import java.util.List;

public interface PersonaService {
    public List<Persona> findAll();

    public Persona save(Persona persona);

    public Persona findById(Long id);

    public void delete(Persona persona);

}
