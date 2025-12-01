/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicolesdecoraciones.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/nicoles_decoraciones?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ Driver MySQL cargado correctamente");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ MySQL Driver not found");
            throw new SQLException("MySQL Driver not found", e);
        }
        
        System.out.println("🔗 Intentando conectar a: " + URL);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("✅ Conexión establecida con la BD");
        return conn;
    }
}