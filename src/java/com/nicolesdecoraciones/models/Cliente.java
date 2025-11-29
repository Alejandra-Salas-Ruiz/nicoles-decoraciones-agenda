/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicolesdecoraciones.models;

import java.util.Date;

public class Cliente {
    private int id;
    private String nombre;
    private String telefono;
    private String email;
    private String tipoEvento;
    private Date fechaReservacion;
    private Date fechaRegistro;
    
    // Constructores
    public Cliente() {}
    
    public Cliente(String nombre, String telefono, String email, String tipoEvento, Date fechaReservacion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.tipoEvento = tipoEvento;
        this.fechaReservacion = fechaReservacion;
    }
    
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getTipoEvento() { return tipoEvento; }
    public void setTipoEvento(String tipoEvento) { this.tipoEvento = tipoEvento; }
    
    public Date getFechaReservacion() { return fechaReservacion; }
    public void setFechaReservacion(Date fechaReservacion) { this.fechaReservacion = fechaReservacion; }
    
    public Date getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", tipoEvento=" + tipoEvento + ", fechaReservacion=" + fechaReservacion + ", fechaRegistro=" + fechaRegistro + '}';
    }
}
