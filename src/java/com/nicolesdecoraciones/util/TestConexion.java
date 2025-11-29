/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicolesdecoraciones.util;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConexion {
    
    public static void main(String[] args) {
        System.out.println("🔍 Probando conexión a la base de datos...");
        
        try {
            Connection conn = DatabaseConnection.getConnection();
            if (conn != null && !conn.isClosed()) {
                System.out.println("✅ CONEXIÓN EXITOSA a la base de datos!");
                System.out.println("📊 Base de datos: nicoles_decoraciones");
                System.out.println("🔗 URL: jdbc:mysql://localhost:3306/nicoles_decoraciones");
                conn.close();
            } else {
                System.out.println("❌ Error: No se pudo establecer conexión");
            }
        } catch (SQLException e) {
            System.out.println("❌ ERROR en la conexión:");
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("🔧 Solución:");
            System.out.println("1. Verifica que XAMPP MySQL esté iniciado");
            System.out.println("2. Verifica que la base de datos 'nicoles_decoraciones' exista");
            System.out.println("3. Verifica el driver MySQL en Libraries");
            e.printStackTrace();
        }
    }
}