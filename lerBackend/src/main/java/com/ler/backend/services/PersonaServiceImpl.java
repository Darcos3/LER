package com.ler.backend.services;

import com.ler.backend.entity.Persona;
import com.ler.backend.repository.PersonaDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private PersonaDao personaDao;

    @Transactional
    public List<Persona> findAll() {
        return (List<Persona>) personaDao.findAll();
    }

    @Transactional
    public Persona save(Persona persona) {
        return personaDao.save(persona);
    }

    public Persona findById(Long id) {
        return personaDao.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Persona persona) {
        personaDao.delete(persona);
    }
}
