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
            // Convertir fecha
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaReservacion = sdf.parse(fechaStr);
            
            // Verificar si la fecha está ocupada
            if (clienteDAO.existeFechaReservacion((java.sql.Date) fechaReservacion)) {
                request.setAttribute("error", "❌ FECHA RESERVADA - Esta fecha ya está ocupada. Por favor seleccione otra fecha.");
                request.getRequestDispatcher("formulario.jsp").forward(request, response);
                return;
            }
            
            // Crear y guardar cliente
            Cliente cliente = new Cliente(nombre, telefono, email, tipoEvento, fechaReservacion);
            boolean exito = clienteDAO.insertarCliente(cliente);
            
            if (exito) {
                request.setAttribute("mensaje", "✅ RESERVACIÓN EXITOSA - Se ha agendado correctamente para " + fechaStr);
            } else {
                request.setAttribute("error", "❌ Error al guardar la reservación");
            }
            
        } catch (Exception e) {
            request.setAttribute("error", "❌ Error en el formato de fecha");
            e.printStackTrace();
        }
        
        request.getRequestDispatcher("formulario.jsp").forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.sendRedirect("formulario.jsp");
    }
}