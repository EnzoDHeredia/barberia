package com.turnos_api.turnos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.util.Date;


@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario cliente;
    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
    private Date fechaHora;
    private String estado;

    public Turno(Usuario cliente, Servicio servicio, Empleado empleado, Date fechaHora, String estado) {
        this.cliente = cliente;
        this.servicio = servicio;
        this.empleado = empleado;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public Turno() {
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
