package com.turnos_api.turnos.controller.dto;

import com.turnos_api.turnos.entities.Empleado;
import com.turnos_api.turnos.entities.Servicio;
import com.turnos_api.turnos.entities.Usuario;

import java.util.Date;

public class TurnoDTO {

    private Long id;
    private Usuario cliente;
    private Servicio servicio;
    private Empleado empleado;
    private Date fechaHora;
    private String estado;

    public TurnoDTO(Usuario cliente, Servicio servicio, Empleado empleado, Date fechaHora, String estado) {
        this.cliente = cliente;
        this.servicio = servicio;
        this.empleado = empleado;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public TurnoDTO() {
    }

    public Long getId() {
        return id;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
}
