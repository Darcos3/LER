package com.ler.backend.controller;

import com.ler.backend.entity.Persona;
import com.ler.backend.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping(value="/personas")
    public ResponseEntity<Object> get(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Persona> list  = personaService.findAll();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/personas/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        try {
            Persona data  = personaService.findById(id);
            return new ResponseEntity<Object>(data,HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value="/personas/create")
    public ResponseEntity<Object> create(@RequestBody Persona persona){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Persona res = personaService.save(persona);
            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/personas/edit/{id}")
    public ResponseEntity<Object> update(@RequestBody Persona persona, @PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {

            Persona currentPerson = personaService.findById(id);

            currentPerson.setNombre(persona.getNombre());
            currentPerson.setNumero_identificacion(persona.getNumero_identificacion());
            currentPerson.setFecha_nacimiento(persona.getFecha_nacimiento());

            Persona res = personaService.save(persona);

            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/personas/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Persona currentPerson = personaService.findById(id);
            personaService.delete(currentPerson);
            map.put("deleted", true);
            return new ResponseEntity<Object>(map,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
