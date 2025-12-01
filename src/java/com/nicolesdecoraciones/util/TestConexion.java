/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicolesdecoraciones.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestConexion {
    
    public static void testConnection() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            System.out.println("✅ CONEXIÓN EXITOSA A LA BD");
            System.out.println(" - URL: jdbc:mysql://localhost:3306/nicoles_decoraciones");
            System.out.println(" - Usuario: root");
            System.out.println(" - BD: nicoles_decoraciones");
            
            // Verificar si la tabla existe
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet tables = dbmd.getTables(null, null, "clientes", null);
            if (tables.next()) {
                System.out.println("✅ Tabla 'clientes' existe");
            } else {
                System.out.println("❌ Tabla 'clientes' NO existe");
            }
            
            // Verificar datos existentes
            ResultSet rs = conn.createStatement().executeQuery("SELECT COUNT(*) as total FROM clientes");
            if (rs.next()) {
                System.out.println("📊 Total de clientes en BD: " + rs.getInt("total"));
            }
            
            conn.close();
            System.out.println("✅ Conexión cerrada correctamente");
            
        } catch (SQLException e) {
            System.err.println("❌ ERROR EN CONEXIÓN:");
            e.printStackTrace();
        }
    }
    
    // Método main para probar directamente
    public static void main(String[] args) {
        System.out.println("=== INICIANDO PRUEBA DE CONEXIÓN ===");
        testConnection();
        System.out.println("=== PRUEBA COMPLETADA ===");
    }
}