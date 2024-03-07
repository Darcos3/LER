package com.ler.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name="persona")
public class Persona implements Serializable {
    private static final long serialVirtualUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotBlank
    @Column(name="numero_identificacion")
    private String numero_identificacion;

    @Column(name="fecha_nacimiento")
    private String fecha_nacimiento;

    @Column(name="nombre")
    private String nombre;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumero_identificacion(String numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }

    public  String getNumero_identificacion(){
        return numero_identificacion;
    }

    public String getFecha_nacimiento(){
        return fecha_nacimiento;
    }
}
