package com.turnos_api.turnos.controller.dto;

public class ServicioDTO {

    private Long id;
    private String nombre;
    private Double precio;

    public ServicioDTO(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public ServicioDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
