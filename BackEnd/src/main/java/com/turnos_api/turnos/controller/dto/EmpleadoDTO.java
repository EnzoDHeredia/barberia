package com.turnos_api.turnos.controller.dto;

public class EmpleadoDTO {

    private Long id;
    private String nombre;
    private String especialidad;

    public EmpleadoDTO(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public EmpleadoDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
