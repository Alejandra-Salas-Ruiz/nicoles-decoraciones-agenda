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
    private java.sql.Date fechaReservacion; // CAMBIO: usar java.sql.Date
    private Date fechaRegistro;
    
    // Constructores
    public Cliente() {}
    
    // Constructor principal con java.sql.Date
    public Cliente(String nombre, String telefono, String email, String tipoEvento, java.sql.Date fechaReservacion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.tipoEvento = tipoEvento;
        this.fechaReservacion = fechaReservacion;
    }
    
    // Constructor alternativo para compatibilidad
    public Cliente(String nombre, String telefono, String email, String tipoEvento, Date fechaReservacion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.tipoEvento = tipoEvento;
        if (fechaReservacion != null) {
            this.fechaReservacion = new java.sql.Date(fechaReservacion.getTime());
        }
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
    
    // Getter para fechaReservacion como java.sql.Date
    public java.sql.Date getFechaReservacion() { 
        return fechaReservacion; 
    }
    
    // Setter para fechaReservacion como java.sql.Date
    public void setFechaReservacion(java.sql.Date fechaReservacion) { 
        this.fechaReservacion = fechaReservacion; 
    }
    
    // Setter alternativo para java.util.Date
    public void setFechaReservacion(Date fechaReservacion) {
        if (fechaReservacion != null) {
            this.fechaReservacion = new java.sql.Date(fechaReservacion.getTime());
        } else {
            this.fechaReservacion = null;
        }
    }
    
    public Date getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", tipoEvento=" + tipoEvento + ", fechaReservacion=" + fechaReservacion + ", fechaRegistro=" + fechaRegistro + '}';
    }
}