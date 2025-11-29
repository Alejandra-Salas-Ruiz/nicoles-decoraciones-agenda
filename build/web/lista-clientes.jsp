<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.nicolesdecoraciones.models.Cliente, java.util.List, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Clientes - Nicole's Decoraciones</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px 0;
        }
    </style>
</head>
<body>
    <div class="container mt-4">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1 class="text-white">👥 Lista de Clientes Registrados</h1>
            <a href="index.html" class="btn btn-secondary">Volver al Inicio</a>
        </div>

        <div class="card shadow">
            <div class="card-header bg-success text-white">
                <h5 class="mb-0">Total de Reservaciones: ${clientes.size()}</h5>
            </div>
            <div class="card-body">
                <% 
                    List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    
                    if (clientes == null || clientes.isEmpty()) {
                %>
                    <div class="alert alert-info text-center">
                        No hay clientes registrados aún.
                    </div>
                <% } else { %>
                    <div class="table-responsive">
                        <table class="table table-striped table-hover">
                            <thead class="table-dark">
                                <tr>
                                    <th>#</th>
                                    <th>Nombre</th>
                                    <th>Teléfono</th>
                                    <th>Email</th>
                                    <th>Evento</th>
                                    <th>Fecha Reservación</th>
                                    <th>Fecha Registro</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (int i = 0; i < clientes.size(); i++) { 
                                    Cliente cliente = clientes.get(i);
                                %>
                                    <tr>
                                        <td><%= i + 1 %></td>
                                        <td><strong><%= cliente.getNombre() %></strong></td>
                                        <td><%= cliente.getTelefono() %></td>
                                        <td><%= cliente.getEmail() != null ? cliente.getEmail() : "N/A" %></td>
                                        <td><span class="badge bg-primary"><%= cliente.getTipoEvento() %></span></td>
                                        <td><span class="badge bg-success"><%= sdf.format(cliente.getFechaReservacion()) %></span></td>
                                        <td><small class="text-muted"><%= sdf.format(cliente.getFechaRegistro()) %></small></td>
                                    </tr>
                                <% } %>
                            </tbody>
                        </table>
                    </div>
                <% } %>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>