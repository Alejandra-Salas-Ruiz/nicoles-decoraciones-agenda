/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nicolesdecoraciones.servlets;

import com.nicolesdecoraciones.dao.ClienteDAO;
import com.nicolesdecoraciones.models.Cliente;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lista-clientes")
public class ListaClientesServlet extends HttpServlet {
    private ClienteDAO clienteDAO;
    
    @Override
    public void init() {
        clienteDAO = new ClienteDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Cliente> clientes = clienteDAO.obtenerTodosClientes();
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("lista-clientes.jsp").forward(request, response);
    }
}
