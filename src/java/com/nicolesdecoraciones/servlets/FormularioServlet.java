/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicolesdecoraciones.servlets;

import com.nicolesdecoraciones.dao.ClienteDAO;
import com.nicolesdecoraciones.models.Cliente;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/formulario")
public class FormularioServlet extends HttpServlet {
    private ClienteDAO clienteDAO;
    
    @Override
    public void init() {
        clienteDAO = new ClienteDAO();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Obtener datos del formulario
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String tipoEvento = request.getParameter("tipoEvento");
        String fechaStr = request.getParameter("fechaReservacion");
        
        try {
            // Validar que todos los campos requeridos estén presentes
            if (nombre == null || nombre.trim().isEmpty() ||
                telefono == null || telefono.trim().isEmpty() ||
                tipoEvento == null || tipoEvento.trim().isEmpty() ||
                fechaStr == null || fechaStr.trim().isEmpty()) {
                
                request.setAttribute("error", "❌ Por favor complete todos los campos requeridos");
                request.getRequestDispatcher("formulario.jsp").forward(request, response);
                return;
            }
            
            // Convertir fecha de String a java.util.Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false); // Validación estricta de fechas
            
            Date fechaUtil = sdf.parse(fechaStr);
            
            // Convertir java.util.Date a java.sql.Date
            java.sql.Date fechaReservacion = new java.sql.Date(fechaUtil.getTime());
            
            // Verificar si la fecha está ocupada
            if (clienteDAO.existeFechaReservacion(fechaReservacion)) {
                request.setAttribute("error", "❌ FECHA RESERVADA - Esta fecha ya está ocupada. Por favor seleccione otra fecha.");
                request.getRequestDispatcher("formulario.jsp").forward(request, response);
                return;
            }
            
            // Crear y guardar cliente usando java.sql.Date
            Cliente cliente = new Cliente(nombre, telefono, email, tipoEvento, fechaReservacion);
            boolean exito = clienteDAO.insertarCliente(cliente);
            
            if (exito) {
                // Formatear fecha para mostrar en el mensaje
                SimpleDateFormat formatoDisplay = new SimpleDateFormat("dd/MM/yyyy");
                String fechaDisplay = formatoDisplay.format(fechaReservacion);
                
                request.setAttribute("mensaje", "✅ RESERVACIÓN EXITOSA - Se ha agendado correctamente para " + fechaDisplay);
                
                // Limpiar el formulario después de éxito
                request.setAttribute("limpiarFormulario", "true");
            } else {
                request.setAttribute("error", "❌ Error al guardar la reservación. Por favor intente nuevamente.");
            }
            
        } catch (java.text.ParseException e) {
            request.setAttribute("error", "❌ Error en el formato de fecha. Use el formato correcto.");
            e.printStackTrace();
        } catch (Exception e) {
            request.setAttribute("error", "❌ Error del sistema: " + e.getMessage());
            e.printStackTrace();
        }
        
        request.getRequestDispatcher("formulario.jsp").forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.sendRedirect("formulario.jsp");
    }
}