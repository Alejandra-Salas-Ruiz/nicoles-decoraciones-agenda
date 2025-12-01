/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicolesdecoraciones.dao;

import com.nicolesdecoraciones.models.Cliente;
import com.nicolesdecoraciones.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    
    public boolean insertarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (nombre, telefono, email, tipo_evento, fecha_reservacion) VALUES (?, ?, ?, ?, ?)";
        
        System.out.println("=== INICIANDO INSERCIÓN EN BD ===");
        System.out.println("SQL: " + sql);
        System.out.println("Datos del cliente:");
        System.out.println(" - Nombre: " + cliente.getNombre());
        System.out.println(" - Teléfono: " + cliente.getTelefono());
        System.out.println(" - Email: " + cliente.getEmail());
        System.out.println(" - Tipo Evento: " + cliente.getTipoEvento());
        System.out.println(" - Fecha Reservación: " + cliente.getFechaReservacion());
        System.out.println(" - Tipo de objeto fecha: " + (cliente.getFechaReservacion() != null ? cliente.getFechaReservacion().getClass().getName() : "NULL"));
        
        try {
            System.out.println("🔗 Intentando obtener conexión...");
            Connection conn = DatabaseConnection.getConnection();
            System.out.println("✅ Conexión a BD establecida exitosamente");
            
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                
                System.out.println("📝 Asignando parámetros al PreparedStatement...");
                stmt.setString(1, cliente.getNombre());
                stmt.setString(2, cliente.getTelefono());
                stmt.setString(3, cliente.getEmail() != null ? cliente.getEmail() : "");
                stmt.setString(4, cliente.getTipoEvento());
                stmt.setDate(5, cliente.getFechaReservacion());
                
                System.out.println("✅ Todos los parámetros asignados correctamente");
                System.out.println("🚀 Ejecutando executeUpdate...");
                
                int filasAfectadas = stmt.executeUpdate();
                System.out.println("✅ ExecuteUpdate completado. Filas afectadas: " + filasAfectadas);
                
                conn.close();
                return filasAfectadas > 0;
            }
            
        } catch (SQLException e) {
            System.err.println("❌ ERROR SQL DETALLADO en insertarCliente:");
            System.err.println(" - Mensaje: " + e.getMessage());
            System.err.println(" - Código de error: " + e.getErrorCode());
            System.err.println(" - Estado SQL: " + e.getSQLState());
            System.err.println(" - StackTrace completo:");
            e.printStackTrace();
            
            // Error específico por tipo de problema
            if (e.getMessage().contains("Table") && e.getMessage().contains("doesn't exist")) {
                System.err.println("🔥 PROBLEMA: La tabla 'clientes' no existe en la BD");
            } else if (e.getMessage().contains("Access denied")) {
                System.err.println("🔥 PROBLEMA: Acceso denegado - usuario/contraseña incorrectos");
            } else if (e.getMessage().contains("Unknown database")) {
                System.err.println("🔥 PROBLEMA: La base de datos 'nicoles_decoraciones' no existe");
            } else if (e.getMessage().contains("Communications link failure")) {
                System.err.println("🔥 PROBLEMA: No se puede conectar al servidor MySQL");
            }
            
            return false;
        } catch (Exception e) {
            System.err.println("❌ ERROR GENERAL en insertarCliente:");
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Cliente> obtenerTodosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes ORDER BY fecha_reservacion DESC";
        
        System.out.println("=== OBTENIENDO TODOS LOS CLIENTES ===");
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("✅ Consulta ejecutada para obtener clientes");
            
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTipoEvento(rs.getString("tipo_evento"));
                cliente.setFechaReservacion(rs.getDate("fecha_reservacion"));
                cliente.setFechaRegistro(rs.getTimestamp("fecha_registro"));
                
                clientes.add(cliente);
            }
            
            System.out.println("✅ Total de clientes obtenidos: " + clientes.size());
            
        } catch (SQLException e) {
            System.err.println("❌ ERROR SQL en obtenerTodosClientes:");
            System.err.println(" - Mensaje: " + e.getMessage());
            e.printStackTrace();
        }
        
        return clientes;
    }
    
    public boolean existeFechaReservacion(java.sql.Date fecha) {
        String sql = "SELECT COUNT(*) FROM clientes WHERE fecha_reservacion = ?";
        
        System.out.println("=== VERIFICANDO FECHA EN BD ===");
        System.out.println("Fecha a verificar: " + fecha);
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            System.out.println("✅ Conexión a BD establecida para verificación de fecha");
            stmt.setDate(1, fecha);
            
            ResultSet rs = stmt.executeQuery();
            System.out.println("✅ Consulta de verificación ejecutada");
            
            if (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("📊 Fecha '" + fecha + "' aparece " + count + " veces en la BD");
                return count > 0;
            }
            
        } catch (SQLException e) {
            System.err.println("❌ ERROR SQL en existeFechaReservacion:");
            System.err.println(" - Mensaje: " + e.getMessage());
            System.err.println(" - Código de error: " + e.getErrorCode());
            System.err.println(" - Estado SQL: " + e.getSQLState());
            e.printStackTrace();
        }
        
        return false;
    }
}