# Nicole's Decoraciones - Sistema de Gestión de Reservaciones

[![GitHub Actions CI](https://github.com/Alejandra-Salas-Ruiz/nicoles-decoraciones-agenda/workflows/Java%20CI/badge.svg)](https://github.com/Alejandra-Salas-Ruiz/nicoles-decoraciones-agenda/actions)

Tabla de Contenidos
- [Descripción del Proyecto](#-descripción-del-proyecto)
- [Problema Identificado](#-problema-identificado)
- [Solución Propuesta](#-solución-propuesta)
- [Arquitectura del Sistema](#️-arquitectura-del-sistema)
- [Requerimientos](#-requerimientos)
- [Instalación](#️-instalación)
- [Configuración](#-configuración)
- [Uso](#-uso)
- [Contribución](#-contribución)
- [Roadmap](#️-roadmap)
- [Estado del Proyecto](#-estado-del-proyecto)

 Descripción del Proyecto
Sistema web desarrollado en Java EE para la gestión automatizada de reservaciones del negocio de decoración **Nicole's Decoraciones**. Permite registrar clientes, gestionar fechas de eventos y prevenir conflictos de agenda mediante validaciones en tiempo real.

Problema Identificado
Nicole Sanchez, propietaria del negocio de decoración, gestiona manualmente las reservaciones en una libreta física, lo que genera:
- Conflictos por doble reservación
- Pérdida de información de clientes
- Tiempo excesivo en consultas de disponibilidad
- Dificultad para acceso remoto a la agenda

Solución Propuesta
Sistema web local que incluye:
- Formulario digital para registro de clientes
- Validación automática de fechas disponibles
- Panel administrativo con vista completa
- Base de datos MySQL para persistencia segura
- Interfaz web accesible desde cualquier navegador

Arquitectura del Sistema
- **Frontend:** HTML5, CSS3, Bootstrap 5, JSP
- **Backend:** Java EE 7, Servlets, Java Beans
- **Base de Datos:** MySQL 8.0, JDBC
- **Servidor:** GlassFish 5+, XAMPP
- **CI/CD:** GitHub Actions, Gitlo (GitHub + Trello)

Para detalles técnicos completos, ver [ARCHITECTURE.md](ARCHITECTURE.md)

Requerimientos
Servidores y Bases de Datos:
- Java JDK 8+
- GlassFish Server 5+
- MySQL 8.0+ (XAMPP recomendado)
- Apache HTTP Server

Paquetes Adicionales:
- Bootstrap 5.3.0
- MySQL Connector/J 8.0.33
- JSTL 1.2

Versiones:
- Java: 8 o superior
- Java EE: 7 o superior
- MySQL: 8.0 o superior

Instalación

 1. ¿Cómo instalar el ambiente de desarrollo?

# Clonar repositorio
git clone https://github.com/Alejandra-Salas-Ruiz/nicoles-decoraciones-agenda.git

# Importar en NetBeans
# 1. File → Open Project
# 2. Seleccionar carpeta del proyecto
# 3. Click derecho en proyecto → Resolve Problems
# 4. Agregar librerías necesarias

2. Configuración de Base de Datos
Iniciar XAMPP (Apache y MySQL)

Abrir phpMyAdmin (http://localhost/phpmyadmin)

Crear base de datos: nicoles_decoraciones

Importar el script SQL incluido en el proyecto

3. Configuración del Servidor
Agregar GlassFish Server en NetBeans

Configurar conexión a MySQL en context.xml

Ejecutar proyecto en GlassFish

¿Cómo ejecutar pruebas manualmente?
Acceder a: http://localhost:8080/NicolesDecoracionesWeb/

Probar formulario de registro

Verificar persistencia en base de datos

Probar validaciones de fecha

¿Cómo implementar la solución en producción?
Ambiente Local:
Exportar WAR file desde NetBeans

Deploy en GlassFish Production Server

Configurar MySQL en modo producción

Nube (Heroku):
Preparar Procfile y system.properties

Configurar ClearDB MySQL add-on

Deploy via Git: git push heroku main

🔧 Configuración
Configuración del Producto:
src/main/webapp/META-INF/context.xml - Configuración de DataSource

src/main/webapp/WEB-INF/web.xml - Configuración de la aplicación

src/main/java/config/database.properties - Propiedades de BD

Configuración de Requerimientos:
Java EE: Configurar como proyecto web dinámico

MySQL: Crear usuario con privilegios

GlassFish: Configurar pool de conexiones JDBC

📖 Uso
Sección de Referencia para Usuario Final:
Acceso: http://localhost:8080/NicolesDecoracionesWeb/

Registro: Llenar formulario con datos del cliente

Consulta: Ver lista completa de reservaciones

Manual completo: USER_MANUAL.md

Sección de Referencia para Administrador:
Panel: Acceso a todas las reservaciones

Mantenimiento: Opciones de backup y restore

Logs: Revisión de actividad del sistema
