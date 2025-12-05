Nicole's Decoraciones - Sistema de Gestión de Reservaciones

## 📋 Tabla de Contenidos
- [Descripción del Proyecto](#-descripción-del-proyecto)
- [Problema Identificado](#-problema-identificado)
- [Solución Propuesta](#-solución-propuesta)
- [Arquitectura del Sistema](#-arquitectura-del-sistema)
- Requerimientos(#-requerimientos)
- Instalación(#️-instalación)
- Configuración(#-configuración)
- Uso(#-uso)
- Contribución](#-contribución)
- Roadmap(#️-roadmap)
- Estado del Proyecto(#-estado-del-proyecto)

---

Descripción del Proyecto
Sistema web desarrollado en Java EE para la gestión automatizada de reservaciones del negocio de decoración **Nicole's Decoraciones**. Permite registrar clientes, gestionar fechas de eventos y prevenir conflictos de agenda mediante validaciones en tiempo real.

[![Drone CI](https://cloud.drone.io/api/badges/Alejandra-Salas-Ruiz/nicoles-decoraciones-agenda/status.svg)](https://cloud.drone.io/Alejandra-Salas-Ruiz/nicoles-decoraciones-agenda)

Problema Identificado
Situación Actual:
-  Agenda manual en libreta física
-  Conflictos por doble reservación
-  Pérdida de información de clientes
-  Tiempo excesivo en gestión manual
-  Sin acceso remoto a la información

 Impacto en el Negocio:
- Pérdida de clientes por fechas no disponibles
- Errores humanos en registro manual
- Dificultad para consultar disponibilidad rápida
- Falta de historial organizado de reservaciones

 Solución Propuesta
 Sistema Web de Gestión de Reservaciones:
- **Interfaz web** accesible desde cualquier navegador
- **Formulario digital** para registro de clientes
- **Validación automática** de fechas disponibles
- **Panel administrativo** con vista completa
- **Base de datos** para persistencia segura
- **Respuesta en tiempo real** para disponibilidad

Beneficios Esperados:
- Eliminación de dobles reservaciones
- Acceso remoto a la información
- Reducción de tiempo de gestión en 70%
- Historial completo de clientes
- Prevención de errores humanos

 Arquitectura del Sistema

 Diagrama de Componentes:
```mermaid
graph TB
    A[Cliente Web] --> B[GlassFish Server]
    B --> C[Servlets Controller]
    C --> D[JSP Views]
    C --> E[ClienteDAO]
    E --> F[MySQL Database]
    G[GitHub Actions CI/CD] --> H[Repositorio]
    I[Drone CI] --> H
